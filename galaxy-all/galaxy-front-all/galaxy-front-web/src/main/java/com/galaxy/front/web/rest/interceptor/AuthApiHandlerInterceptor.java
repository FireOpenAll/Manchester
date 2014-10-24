/**
 * 
 */
package com.galaxy.front.web.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;
import com.google.gson.Gson;

/**
 * @author luolishu
 * 
 */
public class AuthApiHandlerInterceptor implements HandlerInterceptor {

	String AUTH_HEADER_NAME = "Authorization";
	String AUTH_HEADER_NAME2 = "authorization";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token = getToken(request);
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			IgnoreAuth ignoreAuth = AnnotationUtils.findAnnotation(
					handlerMethod.getBeanType(), IgnoreAuth.class);
			if(ignoreAuth!=null){
				return true;
			}
		}
		LoginUserModel userModel =UserUtils.getLoginUser();
		if (StringUtils.isBlank(token)&&userModel==null) {
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("has no token!");
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(resultModel));
			return false;
		}
		userModel = UserUtils.getUserByToken(token);
		if (userModel == null) {
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("token invalid!");
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(resultModel));
			return false;
		}
		if (userModel.isExpired()) {
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("token expired!");
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(resultModel));
			return false;
		}

		return true;
	}

	private String getToken(HttpServletRequest request) {
		String authToken = StringUtils.trimToEmpty(request
				.getHeader(AUTH_HEADER_NAME));
		if(StringUtils.isBlank(authToken)){
			authToken = StringUtils.trimToEmpty(request
					.getHeader(AUTH_HEADER_NAME2));
		}
		if (authToken.startsWith("Bearer")) {
			authToken = StringUtils
					.trim(authToken.substring("Bearer".length()));
		}

		return authToken;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
