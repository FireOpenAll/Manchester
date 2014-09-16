package com.galaxy.front.web.rest.user.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.user.AuthResultModel;

@RestController
@RequestMapping(value = "api/v1/user")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletResponse response) {
		ResultModel result = new ResultModel();
		result.setCode("555555");
		AuthResultModel authModel = new AuthResultModel();
		result.setData(authModel);
		return result;
	}

}
