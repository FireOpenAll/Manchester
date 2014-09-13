package com.galaxy.front.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class UserInfoController {
	@RequestMapping(value = "userinfo",method=RequestMethod.GET)
	public String getUserInfo(){
		return "user/userinfo";
	}
}
