package com.galaxy.front.web.rest.user.controller;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.user.AuthResultModel;
import com.galaxy.service.user.UserService;
import com.google.code.kaptcha.Constants;

@RestController
@RequestMapping(value = "api/v1/user")
public class LoginController {

	@Autowired
	UserService userService;

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request, HttpServletResponse response) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("app login success");

		AuthResultModel authModel = new AuthResultModel();
		authModel.setUserId((long)11110000);
		authModel.setAccessToken("aaaabbbbccccdddd");
		authModel.setRefreshToken("eeeeffffgggghhhh");
		authModel.setExpireshIn(30*24*3600);
		authModel.setCreate(new Date());

		result.setData(authModel);
		return result;
	}

	@RequestMapping(value = "/login_with_openid", method = RequestMethod.POST)
	public Object login_with_openid(HttpServletResponse response) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		AuthResultModel authModel = new AuthResultModel();
		result.setData(authModel);

		return result;
	}
/*
	@RequestMapping(value = "/profiles", method = RequestMethod.POST)
	public Object updateProfiles() {
		return null;
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public Object getProfiles() {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("get profiles");
		// AuthResultModel authModel = new AuthResultModel();
		result.setData("ok");
		return result;
	}
*/

}
