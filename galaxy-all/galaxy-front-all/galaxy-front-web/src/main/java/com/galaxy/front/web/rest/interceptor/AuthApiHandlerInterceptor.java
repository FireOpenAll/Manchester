/**
 * 
 */
package com.galaxy.front.web.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;

/**
 * @author luolishu
 *
 */
public class AuthApiHandlerInterceptor implements HandlerInterceptor {
	
	
	
	 
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token=getToken(request);
		if(StringUtils.isBlank(token)){
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("has no token!");
			return false;
		}
		LoginUserModel userModel=UserUtils.getUserByToken(token);
		if(userModel==null){
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("token invalid!");
			return false;
		}
		if(userModel.isExpired()){
			ResultModel resultModel = new ResultModel();
			resultModel.setCode("40300");
			resultModel.setData("token expired!");
			return false;
		}
		return true;
	}

	private String getToken(HttpServletRequest request){
		return null;
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
