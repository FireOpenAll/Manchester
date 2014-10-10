package com.galaxy.front.web.rest.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.galaxy.front.web.utils.Constans;
import com.galaxy.front.web.utils.EmailUtils;
import com.galaxy.front.web.utils.MD5Utils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.service.user.UserService;

/*author:huangshanqi
 *time  :2014年10月5日 下午10:34:37
 *email :hsqmobile@gmail.com
 */
@Controller(value = "restEmailController")
@RequestMapping(value = "api/v1/email")
public class EmailController {

	@Autowired
	private UserService userService;

	/**
	 * 验证邮箱验证链接
	 * @param request
	 * @param email
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "verify", method = RequestMethod.GET, params = { "email", "code" })
	public String verifyCode(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("code") String code) {
		StringBuffer stringBuffer = new StringBuffer("");
		request.setAttribute("email", email);
		
		if (RegexUtils.checkEmail(email) && MD5Utils.verifyMD2(email, code)) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("email", email);
			map.put("email_auth", true);
			
			userService.setUserEmailAuthByEmail(map);
			/*
			stringBuffer.append("邮箱验证成功,");
			stringBuffer.append(email).append(" 马上登陆：");
			stringBuffer.append(Constans.localhost);
			stringBuffer.append("user/login");
			request.setAttribute("message", stringBuffer.toString());
			*/
			return "user/email_verify_success";

		} else {
			stringBuffer.append("邮箱验证失败,链接已失效或地址错误！");
			stringBuffer.append(email).append(" 重新注册：");
			stringBuffer.append(Constans.localhost);
			stringBuffer.append("user/register");
			request.setAttribute("message", stringBuffer.toString());
		}

		return "user/email_verify_failed";
	}
}
