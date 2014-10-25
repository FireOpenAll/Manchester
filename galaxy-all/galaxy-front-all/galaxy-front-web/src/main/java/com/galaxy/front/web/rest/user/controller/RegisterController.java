package com.galaxy.front.web.rest.user.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserType;
import com.galaxy.front.web.rest.interceptor.IgnoreAuth;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.EmailUtils;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.UserService;

@RestController(value = "restRegisterController")
@RequestMapping(value = "api/v1/user")
@IgnoreAuth
public class RegisterController {

	/**
	 * 客户端注册控制器
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private EmailUtils emailUtils;
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST,params = {"username","password","email"})
	public Object registerByEmail(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email) {
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(username,password,email)) {
			if (userService.countUsersByLoginName(username)>0) {
				//用户名已注册
				resultModel = ResultModelUtils.getResultModelByCode(Code.USER_NAME_USED);
				resultModel.setData("用户名已被注册");
				return resultModel;
			}
			if (userService.countUsersByEmail(email)>0) {
				//邮箱已注册
				resultModel = ResultModelUtils.getResultModelByCode(Code.EMAIL_USED);
				resultModel.setData("邮箱已被注册");
				return resultModel;
			}
			if (RegexUtils.checkAll(username, password, email, null)) {
				User user = new User();
				user.setLoginName(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(null);
				user.setNick(username);
				user.setCreatedTime(new Date());
				user.setEmailAuth(true);
				user.setMobileAuth(false); 
				user.setHasPic(false);
				user.setType(UserType.NORMAL); 
				userService.createUser(user);
				
				//邮箱验证
				
				
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData("success");
				return resultModel;
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.REGISTER_ERROR);
				resultModel.setData("参数不符合要求");
				return resultModel;
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
        	resultModel.setData(Code.PARAMS_ERROR.name());
        	return resultModel;
		}
		
		
		
	}
	

	/**
	 * 客户端邮箱注册表单提交
	 * 
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */
	/*
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Object register(HttpServletRequest request,RegisterForm form) {
		ResultModel resultModel = new ResultModel();
        String loginName=null;
        String longType = null;//邮箱或者手机号
        if (form.getUsername() == null) {
        	resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
        	resultModel.setData("请填入登录名");
        	return resultModel;
		}
        longType = (form.getEmail()== null)?(form.getPhone_num()):(form.getEmail());
        if (longType == null) {
        	resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
        	resultModel.setData("请用邮箱或手机号注册");
        	return resultModel;
		}
        if (userService.countUsersByLoginName(loginName)>0 || userService.c) {
			
		}
        if(form.getEmail()!=null){
        	loginName=form.getEmail();
        }
        if(form.getPhone_num()!=null){
        	loginName=form.getPhone_num();
        }
        if(form.getUsername()!=null){
        	loginName=form.getUsername();
        }
        if(StringUtils.isBlank(loginName)){
        	resultModel = ResultModelUtils
					.getResultModelByCode(Code.PARAMS_ERROR);
        	resultModel.setData(Code.PARAMS_ERROR.name());
        	return resultModel;
        }
        User user=userService.findUserByLoginName(loginName);
        if(user!=null){
        	resultModel = ResultModelUtils
					.getResultModelByCode(Code.USER_NAME_USED);
			resultModel.setData(Code.USER_NAME_USED.name());
			return resultModel;
        }
        user = new User();
		user.setLoginName(loginName);
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setMobile(form.getPhone_num());
		user.setNick(form.getUsername());
		user.setCreatedTime(new Date());
		user.setEmailAuth(false);
		user.setMobileAuth(false); 
		user.setHasPic(false);
		user.setType(UserType.NORMAL); 
		userService.createUser(user);
		if(user.getId()==null||user.getId()<=0){
			resultModel = ResultModelUtils.getResultModelByCode(Code.FAILURE);
			resultModel.setData("success");
			return resultModel;
		} 
		
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData("success");
		notifyRegister(user);
		return resultModel;
		 
	}
	*/
	private void notifyRegister(User user){
//		String code = MD5Utils.encode2String(email);
//
//		StringBuilder stringBuilder = new StringBuilder("");
//		stringBuilder.append("欢迎注册galaxy，点击以下完成邮箱验证!").append("\n");
//		stringBuilder.append(Constans.remotehost);
//		stringBuilder.append("api/v1/email/verify?email=")
//				.append(email);
//		stringBuilder.append("&code=").append(code);
//		stringBuilder.append("\n");
//
//		emailUtils.sendMail("galaxy邮箱验证", stringBuilder.toString(),
//				email);
//
//		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
//		resultModel.setData("注册成功，请前往邮箱点击链接已完成验证");
	}
 

	public static class RegisterForm {
		String username;
		String email;
		String password;
		String phone_num;
		String verify_code;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone_num() {
			return phone_num;
		}
		public void setPhone_num(String phone_num) {
			this.phone_num = phone_num;
		}
		public String getVerify_code() {
			return verify_code;
		}
		public void setVerify_code(String verify_code) {
			this.verify_code = verify_code;
		}
		
	}

}
