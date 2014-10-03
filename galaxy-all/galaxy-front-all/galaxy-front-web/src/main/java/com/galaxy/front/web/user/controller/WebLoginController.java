package com.galaxy.front.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class WebLoginController {
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String doLogin(){
		return "user/loginSuccess";
	}

}
