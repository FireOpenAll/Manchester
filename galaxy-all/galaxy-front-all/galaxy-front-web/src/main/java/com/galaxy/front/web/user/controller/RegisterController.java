package com.galaxy.front.web.user.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.utils.Constans;
import com.galaxy.front.web.utils.EmailUtils;
import com.galaxy.front.web.utils.MD5Utils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.service.activity.form.RegisterForm;
import com.galaxy.service.user.UserService;

@Controller
@RequestMapping(value = "user")
public class RegisterController {

	/**
	 * web 注册
	 */

	@Autowired
	UserService userService;
	@Autowired
	EmailUtils emailUtils;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	/* web邮箱注册 */
	@RequestMapping(value = "register", method = RequestMethod.POST, params = {
			"username", "email", "password" })
	public String doRegisterByEmail(HttpServletRequest request,
			RegisterForm registerForm) {
		String username = registerForm.getUsername();
		String email = registerForm.getEmail();
		String password = registerForm.getPassword();
		if (RegexUtils.checkAll(username, password, email, null)) {
			if (userService.countUsersByEmail(email) > 0) {
				// email 已被注册
				request.setAttribute("message", "该邮箱已被注册,请重新注册!");
			} else {
				// email可用
				User user = new User();
				user.setLoginName(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setCreatedTime(new Timestamp(new Date().getTime()));
				user.setEmailAuth(false);
				userService.createUser(user);

				String code = MD5Utils.encode2String(email);

				StringBuilder stringBuilder = new StringBuilder("");
				stringBuilder.append("欢迎注册galaxy，点击以下完成邮箱验证!").append("\n");
				stringBuilder.append(Constans.remotehost);
				stringBuilder.append("api/v1/email/verify?email=")
						.append(email);
				stringBuilder.append("&code=").append(code);
				stringBuilder.append("\n");

				emailUtils.sendMail("galaxy邮箱验证", stringBuilder.toString(),
						email);

				request.setAttribute("message", "注册成功，请前往邮箱点击链接已完成验证");
				return "user/register_result";
			}
		} else {
			request.setAttribute("message", "参数错误，请从新提交！");
		}
		return "user/register";
	}

}
