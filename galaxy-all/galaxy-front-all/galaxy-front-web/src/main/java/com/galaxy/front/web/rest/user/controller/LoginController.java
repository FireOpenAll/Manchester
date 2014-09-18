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

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(HttpServletRequest request) {
		ResultModel result = new ResultModel();
		if (null != request.getParameter("email")) {
			// 邮箱注册
			String kaptchaExpected = null;
			kaptchaExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
			String kaptchaReceived = request.getParameter("verify_code");

			if (kaptchaExpected!=null&&kaptchaExpected.equalsIgnoreCase(kaptchaReceived)) {
				
				result.setCode("20000");
				result.setMessage("email register success");
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.setStatus("ok");
				result.setData(messageInfo);
			}else {
				result.setCode("10000");
				result.setMessage("verifyCode error");
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.setStatus("error");
				result.setData(messageInfo);
			}
			/*
			if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) {
				
			}*/
		} else {
			// 手机号注册
			result.setCode("20000");
			result.setMessage("phone_number register success");
			MessageInfo messageInfo = new MessageInfo();
			messageInfo.setStatus("ok");
			result.setData(messageInfo);
		}
		
		return result;
	}

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

	public static class MessageInfo implements Serializable {
		private String status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

}
