/**
 * 
 */
package com.galaxy.front.web.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserContext;
import com.galaxy.service.user.UserUtils;
import com.google.gson.Gson;

/**
 * @author luolishu
 * 
 */
public class ContextHandlerInterceptor implements HandlerInterceptor {
	static Logger logger=LoggerFactory.getLogger(ContextHandlerInterceptor.class);

	public static final String AUTH_HEADER_NAME = "Authorization";
	public static final String AUTH_HEADER_NAME2 = "authorization";
	public static final String TOKEN_PARAM_NAME="_token_";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token = getToken(request);
		UserContext context=new UserContext();
		UserContext.setContext(context);
		context.setToken(token);
		return true;
	}

	private String getToken(HttpServletRequest request) {
		String authToken = StringUtils.trimToEmpty(request
				.getHeader(AUTH_HEADER_NAME));
		if(StringUtils.isBlank(authToken)){
			authToken = StringUtils.trimToEmpty(request
					.getHeader(AUTH_HEADER_NAME2));
		}
		if(StringUtils.isBlank(authToken)){
			authToken = StringUtils.trimToEmpty(request.getParameter(TOKEN_PARAM_NAME));
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
		UserContext.setContext(null);

	}

}
