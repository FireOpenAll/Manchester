package com.galaxy.front.web.rest.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constans;
import com.galaxy.front.web.utils.MD5Utils;
import com.galaxy.front.web.utils.MailUtils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
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

	@Autowired
	private MailUtils mailUtils;

	/**
	 * @param request
	 * @param email
	 * @return ResultModel
	 */

	@ResponseBody
	@RequestMapping(value = "check", method = RequestMethod.GET,params = {"email"})
	public Object check(HttpServletRequest request, @RequestParam("email") String email) {
		ResultModel resultModel = new ResultModel();
		
		if (RegexUtils.checkEmail(email)) {
			int count = userService.countUsersByEmail(email);
			if (count > 0) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_USED);
				resultModel.setData(new StatusModel("email unusable"));
			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("email usable"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_FORMAT_ERROR);
			resultModel.setData(new StatusModel("email format error"));
		}
		
		
		return resultModel;
	}

	/**
	 * @param request
	 * @param email
	 * @return ResultModel
	 */
	@ResponseBody
	@RequestMapping(value = "send", method = RequestMethod.GET, params = { "email" })
	public Object send(HttpServletRequest request, @RequestParam("email") String email) {

		ResultModel resultModel = new ResultModel();
		if (RegexUtils.checkEmail(email)) {
			String code = MD5Utils.encode2String(email);

			StringBuilder stringBuilder = new StringBuilder("");
			stringBuilder.append("欢迎注册galaxy，点击以下完成邮箱验证!").append("\n");
			stringBuilder.append(Constans.localhost);
			stringBuilder.append("api/v1/email/verify?email=").append(email);
			stringBuilder.append("&code=").append(code);
			stringBuilder.append("\n");

			mailUtils.sendMail("galaxy邮箱验证", stringBuilder.toString(), email);

			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("已向 " + email + " 邮箱发送验证链接,前去邮箱点击链接完成验证"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_FORMAT_ERROR);
			resultModel.setData(new StatusModel("email format error"));
		}

		return resultModel;
	}

	
	@RequestMapping(value = "verify", method = RequestMethod.GET, params = { "email", "code" })
	public String verifyCode(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("code") String code) {
		StringBuffer stringBuffer = new StringBuffer("");
		if (RegexUtils.checkEmail(email) && MD5Utils.verifyMD2(email, code)) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("email", email);
			map.put("email_auth", true);
			userService.setUserEmailAuthByEmail(map);
			
			stringBuffer.append("邮箱验证成功,");
			stringBuffer.append(email).append(" 马上登陆：");
			stringBuffer.append(Constans.localhost);
			stringBuffer.append("user/login");
			request.setAttribute("message", stringBuffer.toString());

		} else {
			stringBuffer.append("邮箱验证失败,链接已失效或地址错误！");
			stringBuffer.append(email).append(" 重新注册：");
			stringBuffer.append(Constans.localhost);
			stringBuffer.append("user/register");
			request.setAttribute("message", stringBuffer.toString());
		}

		return "user/email_verify";
	}
}
