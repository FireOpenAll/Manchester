package com.galaxy.front.web.rest.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.user.AuthResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.RegexUtils;
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
	 * 客户端登陆
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "logintext", "password" })
	public Object loginByEmail(HttpServletRequest request, @RequestParam("logintext") String logintext,
			@RequestParam("password") String password) {
		ResultModel resultModel = new ResultModel();

		User user;
		if (RegexUtils.checkEmail(logintext)) {
			// 邮箱登陆
			Map<String, String> map = new HashMap<String, String>();
			map.put("password", password);
			map.put("email", logintext);
			user = userService.getUserbyEmailPassword(map);
			if (user != null && user.isEmailAuth()) {

				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);

				AuthResultModel authModel = new AuthResultModel();
				authModel.setUserId(user.getId());
				authModel.setAccessToken("aaaabbbbccccdddd");
				authModel.setRefreshToken("eeeeffffgggghhhh");
				authModel.setExpireshIn(30 * 24 * 3600);
				authModel.setCreate(new Date());

				resultModel.setData(authModel);

			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_NOT_AUTH);
				resultModel.setData("你的邮箱尚未进行验证，请前去邮箱点击链接进行验证");
			}
		} else if (RegexUtils.checkPhone(logintext)) {
			// 手机登录
			Map<String, String> map = new HashMap<String, String>();
			map.put("password", password);
			map.put("mobile", logintext);
			user = userService.getUserbyMobilePassword(map);
			if (user != null && user.isMobileAuth()) {

				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);

				AuthResultModel authModel = new AuthResultModel();
				authModel.setUserId(user.getId());
				authModel.setAccessToken("aaaabbbbccccdddd");
				authModel.setRefreshToken("eeeeffffgggghhhh");
				authModel.setExpireshIn(30 * 24 * 3600);
				authModel.setCreate(new Date());

				resultModel.setData(authModel);

			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_NOT_AUTH);
				resultModel.setData("你的手机尚未进行验证，从新发送手机验证码");
			}
		} else if (RegexUtils.checkName(logintext)) {
			// 用户名登录
			Map<String, String> map = new HashMap<String, String>();
			map.put("password", password);
			map.put("login_name", logintext);
			user = userService.getUserbyLoginNamePassword(map);
			if (user != null && (user.isMobileAuth() || user.isEmailAuth())) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);

				AuthResultModel authModel = new AuthResultModel();
				authModel.setUserId(user.getId());
				authModel.setAccessToken("aaaabbbbccccdddd");
				authModel.setRefreshToken("eeeeffffgggghhhh");
				authModel.setExpireshIn(30 * 24 * 3600);
				authModel.setCreate(new Date());

				resultModel.setData(authModel);

			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_NOT_AUTH);
				resultModel.setData("你的账户尚未进行验证，请进行手机号或邮箱认证");
			}
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.LOGIN_FAILED);
			resultModel.setData("登录失败，用户名或密码错误");
		}
		return resultModel;
	}
	
}
