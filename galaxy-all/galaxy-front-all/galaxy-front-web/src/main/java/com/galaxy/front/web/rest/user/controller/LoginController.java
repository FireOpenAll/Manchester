package com.galaxy.front.web.rest.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.user.AuthResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.UserService;

@RestController
@RequestMapping(value = "api/v1/user")
public class LoginController {

	/**
	 * 手机端登陆
	 */

	@Autowired
	UserService userService;

	/**
	 * 邮箱+密码登陆
	 * 
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "email", "password" })
	public Object loginByEmail(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		ResultModel resultModel = new ResultModel();

		if (userService.checkEmailAuth(email)) {
			User user = null;
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			user = userService.getUserbyEmailPassword(paramMap);
			if (user == null) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.LOGIN_FAILED);
				resultModel.setData("登录失败，邮箱或密码错误");

			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);

				AuthResultModel authModel = new AuthResultModel();
				authModel.setUserId(user.getId());
				authModel.setAccessToken("aaaabbbbccccdddd");
				authModel.setRefreshToken("eeeeffffgggghhhh");
				authModel.setExpireshIn(30 * 24 * 3600);
				authModel.setCreate(new Date());

				resultModel.setData(authModel);
			}

		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_NOT_AUTH);
			resultModel.setData("不存在此用户或该邮箱未认证");
		}

		return resultModel;
	}

	/**
	 * 手机号+密码登陆
	 * 
	 * @param request
	 * @param mobile
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "mobile", "password" })
	public Object loginByMobile_Password(HttpServletRequest request, @RequestParam("mobile") String mobile,
			@RequestParam("password") String password) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("app login success");

		AuthResultModel authModel = new AuthResultModel();
		authModel.setUserId((long) 11110000);
		authModel.setAccessToken("aaaabbbbccccdddd");
		authModel.setRefreshToken("eeeeffffgggghhhh");
		authModel.setExpireshIn(30 * 24 * 3600);
		authModel.setCreate(new Date());

		result.setData(authModel);
		return result;
	}

	/**
	 * 手机号+动态码登陆
	 * 
	 * @param request
	 * @param mobile
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "mobile", "code" })
	public Object loginByMobile_code(@RequestParam("mobile") String mobile, @RequestParam("code") String code) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("app login success");

		AuthResultModel authModel = new AuthResultModel();
		authModel.setUserId((long) 11110000);
		authModel.setAccessToken("aaaabbbbccccdddd");
		authModel.setRefreshToken("eeeeffffgggghhhh");
		authModel.setExpireshIn(30 * 24 * 3600);
		authModel.setCreate(new Date());

		result.setData(authModel);
		return result;
	}

	/**
	 * 用户名+密码登陆
	 * 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "username", "password" })
	public Object loginByName(@RequestParam("username") String username, @RequestParam("password") String password) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("app login success");

		AuthResultModel authModel = new AuthResultModel();
		authModel.setUserId((long) 11110000);
		authModel.setAccessToken("aaaabbbbccccdddd");
		authModel.setRefreshToken("eeeeffffgggghhhh");
		authModel.setExpireshIn(30 * 24 * 3600);
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

}
