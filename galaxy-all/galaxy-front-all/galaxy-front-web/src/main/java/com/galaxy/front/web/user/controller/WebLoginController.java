package com.galaxy.front.web.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.service.user.UserService;
import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping(value = "user")
public class WebLoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST,params={"username","password","captcha"})
	public String doLogin(HttpServletRequest request){
//		if (captcha.equalsIgnoreCase(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString())) {
//			User user;
//			if (RegexUtils.checkEmail(logintext)) {
//				//邮箱登陆
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("password", password);
//				map.put("email", logintext);
//				user = userService.findUserByLoginName(logintext);
//				if (user != null && user.isEmailAuth()) {
//					request.getSession().setAttribute("userId", user.getId());
//					request.getSession().setAttribute("userName", user.getLoginName());
//					return "activity/create";
//				}else {
//					request.setAttribute("message", "你的邮箱尚未进行验证，请前去邮箱点击链接进行验证");
//					return "activity/login_result";
//				}
//			}else if(RegexUtils.checkPhone(logintext)){
//				//手机登录
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("password", password);
//				map.put("mobile", logintext);
//				user = userService.findUserByLoginName(logintext);
//				if (user != null && user.isMobileAuth()) {
//					request.getSession().setAttribute("userId", user.getId());
//					request.getSession().setAttribute("userName", user.getLoginName());
//					return "activity/postactivity";
//				}else {
//					request.setAttribute("message", "你的手机尚未进行验证，从新发送手机验证码");
//					return "activity/login_result";
//				}
//			}else if(RegexUtils.checkName(logintext)){
//				//用户名登录
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("password", password);
//				map.put("login_name", logintext);
//				user = userService.findUserByLoginName(logintext);
//				System.err.println("username == "+user.getLoginName());
//				if (user != null && (user.isMobileAuth() || user.isEmailAuth())) {
//					request.getSession().setAttribute("userId", user.getId());
//					request.getSession().setAttribute("userName", user.getLoginName());
//					System.err.println("userId"+request.getSession().getAttribute("userId"));
//					System.err.println("userName"+request.getSession().getAttribute("userName"));
//					return "activity/create";
//				}else {
//					request.setAttribute("message", "你的账户尚未进行验证，请进行手机号或邮箱认证");
//					return "user/login";
//				}
//			}else {
//				request.setAttribute("message", "登录失败，用户名或密码错误");
//				return "user/login";
//			}
//		}else {
			request.setAttribute("message", "登录失败");
			return "user/login";
	}
	
	

}
