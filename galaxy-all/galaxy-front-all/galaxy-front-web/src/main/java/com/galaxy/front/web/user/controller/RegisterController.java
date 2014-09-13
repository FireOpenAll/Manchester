package com.galaxy.front.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class RegisterController {
	@RequestMapping(value = "register",method=RequestMethod.GET)
	public String register(){
		return "user/register";
	}
	
	@RequestMapping(value = "register",method=RequestMethod.POST)
	public String doRegister(){
		return "user/register";
	}

}
