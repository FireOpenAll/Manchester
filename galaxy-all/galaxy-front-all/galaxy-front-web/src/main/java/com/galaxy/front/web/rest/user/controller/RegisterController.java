package com.galaxy.front.web.rest.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.front.web.Utils.Code;
import com.galaxy.front.web.Utils.RegexUtils;
import com.galaxy.front.web.Utils.ResultModelUtils;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.service.user.UserService;
import com.google.code.kaptcha.Constants;

@RestController(value ="restRegisterController")
@RequestMapping(value = "api/v1/user")
public class RegisterController {

	/**
	 * 客户端注册控制器
	 */
	@Autowired
	private UserService userService;
	

	/**
	 * @param request
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "checkMobileUsable",method = RequestMethod.GET)
	public Object checkMobileUsable(HttpServletRequest request,@PathVariable("mobile") String mobile){
		ResultModel resultModel = new ResultModel();
		int count = userService.countUsersByMobile(mobile);
		if (count>0) {
			resultModel.setCode("30000");
			resultModel.setMessage("该手机号已经被注册，请换一个手机号注册！");
			resultModel.setData(new StatusModel("mobile unusable"));
		}else {
			resultModel.setCode("20000");
			resultModel.setMessage("该手机号可以注册！");
			resultModel.setData(new StatusModel("mobile usable"));
		}
		return resultModel;
	}
	
	/**
	 * @param request
	 * @param login_name
	 * @return
	 */
	@RequestMapping(value = "checkLoginNameUsable",method = RequestMethod.GET,params = {"login_name"})
	public Object checkLoginNameUsable(HttpServletRequest request,@PathVariable("login_name") String login_name){
		
		ResultModel resultModel = new ResultModel();
		if (RegexUtils.checkName(login_name)) {
			int count = userService.countUsersByLoginName(login_name);
			if (count>0) {
				resultModel.setCode(Code.USER_NAME_USED.getCode());
				resultModel.setMessage(Code.USER_NAME_USED.getMessage());
				resultModel.setData(new StatusModel("login_name has been used"));
			}else {
				resultModel.setCode(Code.OK.getCode());
				resultModel.setMessage(Code.OK.getMessage());
				resultModel.setData(new StatusModel("login_name usable"));
			}
		}else {
			resultModel.setCode(Code.USER_NAME_FORMAT_ERROR.getCode());
			resultModel.setMessage(Code.USER_NAME_FORMAT_ERROR.getMessage());
			resultModel.setData(new StatusModel("login_name format error"));
		}
		
		return resultModel;
	}
	
	@RequestMapping(value = "register",method = RequestMethod.POST,params = {"email","password"})
	public Object registerByEmail(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("password") String password){
		ResultModel resultModel = new ResultModel();
		
		if (RegexUtils.checkEmail(email)&&RegexUtils.checkPassword(password)) {
			if (userService.countUsersByEmail(email)>0) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_USED);
			}else {
				User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setEmailAuth(false);
				
				userService.createUser(user);
				
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData("email register success");
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		/*
		if (RegexUtils.checkEmail(email)) {
			if (userService.countUsersByEmail(email)>0) {
				//email已被注册
				resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_USED);
			} else {
				if (RegexUtils.checkPassword(password)) {
					
					resultModel.setCode(Code.OK.getCode());
					resultModel.setMessage(Code.OK.getMessage());
				}else {
					resultModel = ResultModelUtils.getResultModelByCode(Code.PASSWORD_FORMAT_ERROR);
				}
			}
		}else {
			resultModel= ResultModelUtils.getResultModelByCode(Code.EMAIL_FORMAT_ERROR);
		}
		*/
		
		return resultModel;
	}
	
	/*
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
	
	*/
}
