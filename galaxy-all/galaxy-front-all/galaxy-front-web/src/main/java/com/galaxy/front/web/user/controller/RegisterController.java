package com.galaxy.front.web.user.controller;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserType;
import com.galaxy.service.user.UserService;

@Controller
@RequestMapping(value = "user")
public class RegisterController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String doRegister(RegisterForm form, String redirectUrl) {
		// 检查密码是否相等，检查邮箱合法性，检查验证码
		User user = new User();
		user.setLoginName(form.getMember_name());
		user.setEmail(form.getEmail());
		user.setMobile(form.getMobile());
		user.setPassword(form.getPassword());
		user.setCreatedTime(new Date());
		user.setType(UserType.NORMAL);
		userService.createUser(user);
		return "redirect:" + redirectUrl;
	}

	public static class RegisterForm implements Serializable {
		String member_name;
		String password;
		String password_confirm;
		String mobile;
		String email;
		String captcha;
		Integer agree;

		public RegisterForm() {
		}

		public String getMember_name() {
			return member_name;
		}

		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword_confirm() {
			return password_confirm;
		}

		public void setPassword_confirm(String password_confirm) {
			this.password_confirm = password_confirm;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCaptcha() {
			return captcha;
		}

		public void setCaptcha(String captcha) {
			this.captcha = captcha;
		}

		public Integer getAgree() {
			return agree;
		}

		public void setAgree(Integer agree) {
			this.agree = agree;
		}

	}

}
