package com.galaxy.front.web.rest.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.google.code.kaptcha.Constants;

@RestController(value ="restRegisterController")
@RequestMapping(value = "api/v1/user")
public class RegisterController {

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
				StatusModel messageInfo = new StatusModel();
				messageInfo.setStatus("ok");
				result.setData(messageInfo);
			}else {
				result.setCode("10000");
				result.setMessage("verifyCode error");
				StatusModel messageInfo = new StatusModel();
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
			StatusModel messageInfo = new StatusModel();
			messageInfo.setStatus("ok");
			result.setData(messageInfo);
		}
		
		return result;
	}
}
