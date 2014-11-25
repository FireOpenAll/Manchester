package com.galaxy.front.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2014年11月18日 上午11:04:26
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value="account")
public class AccountController {

	@RequestMapping(value = "settings",method=RequestMethod.GET)
	public String getAccountSettings(HttpServletRequest request){
		
		return "account/settings";
	}
	
	@RequestMapping(value = "userinfo",method=RequestMethod.GET)
	public String getUserinfo(HttpServletRequest request){
		
		return "account/userinfo";
	}

	
}
