package com.galaxy.front.web.rest.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.interceptor.IgnoreAuth;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.user.AuthResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

@RestController
@RequestMapping(value = "api/v1/user")
@IgnoreAuth
public class LoginController {

	/**
	 * 手机端登陆
	 */

	@Autowired
	UserService userService;
 

	/**
	 * 客户端登陆
	 * 
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = {
			"logintext", "password" })
	public Object loginShiro(HttpServletRequest request,
			@RequestParam("logintext") String logintext,
			@RequestParam("password") String password) {
		ResultModel resultModel = new ResultModel(); 
		boolean rememberMe=false;
		String host=request.getRemoteHost(); 
		AuthenticationToken authToken=this.createToken(logintext, password, rememberMe, host); 
		 
		try {
			Subject subject=SecurityUtils.getSubject();
            subject.login(authToken);
            resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
            LoginUserModel loginedUser=(LoginUserModel) subject.getPrincipal();
			AuthResultModel authModel = new AuthResultModel();
			authModel.setUserId(loginedUser.getUserId());
			authModel.setAccessToken(loginedUser.getToken());
			authModel.setRefreshToken(loginedUser.getExpiredToken());
			authModel.setExpireshIn(loginedUser.getExpireshIn());
			authModel.setCreate(loginedUser.getLoginedTime());
			

			resultModel.setData(authModel);
			UserUtils.setSubject(loginedUser.getToken(), subject);
        } catch (AuthenticationException e) {
        	resultModel = ResultModelUtils.getResultModelByCode(Code.LOGIN_FAILED);
			resultModel.setData("登录失败，用户名或密码错误"); 
        }
		return resultModel;
	}
	

	protected AuthenticationToken createToken(String username, String password,
			boolean rememberMe, String host) {
		return new UsernamePasswordToken(username, password, rememberMe, host);
	}
}
