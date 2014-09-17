package com.galaxy.front.web.rest.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.service.user.UserService;

@RestController
//@RequestMapping(value = "api/v1/user")
public class UserController {
	@Autowired
	UserService userService;

	/*
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register() {
		return null;
	}

	@RequestMapping(value = "/restlogin", method = RequestMethod.POST)
	public Object login(HttpServletResponse response) {
		ResultModel result = new ResultModel();
		result.setCode("555555");
		AuthResultModel authModel = new AuthResultModel();
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
		result.setCode("122222");
		AuthResultModel authModel = new AuthResultModel();
		result.setData(authModel);
		return result;
	}

*/
	public static class LoginParam {
		String apikey;
		String udid;
		String authToken;

		public String getApikey() {
			return apikey;
		}

		public void setApikey(String apikey) {
			this.apikey = apikey;
		}

		public String getUdid() {
			return udid;
		}

		public void setUdid(String udid) {
			this.udid = udid;
		}

		public String getAuthToken() {
			return authToken;
		}

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

	}

	public static class AuthResultModel implements Serializable {
		private String userId;
		private String authToken;
		private long expiredAt;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getAuthToken() {
			return authToken;
		}

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

		public long getExpiredAt() {
			return expiredAt;
		}

		public void setExpiredAt(long expiredAt) {
			this.expiredAt = expiredAt;
		}

	}

	public static class Person implements Serializable {
		String name = "adfas";
		String age = "33";

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

	}

}
