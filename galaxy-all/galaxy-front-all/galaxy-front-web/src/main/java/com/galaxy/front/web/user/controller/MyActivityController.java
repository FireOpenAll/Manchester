package com.galaxy.front.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

@Controller
@RequestMapping(value = "user")
public class MyActivityController {
	@Autowired
	private UserService userService;
	
	//,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize
	@RequestMapping(value = "myactivity",method=RequestMethod.GET)
	public String getMyActivity(HttpServletRequest request){
		return "user/mypublished";
	}
	
	 
}
