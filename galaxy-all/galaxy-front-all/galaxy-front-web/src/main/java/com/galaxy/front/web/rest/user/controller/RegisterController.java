package com.galaxy.front.web.rest.user.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserType;
import com.galaxy.front.web.rest.interceptor.IgnoreAuth;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.EmailUtils;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.card.CardService;
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
	@Autowired
	private CardService cardService;
	
	/**
	 * 客户端邮箱注册
	 * @param request
	 * @param username
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "registerByEmail", method = RequestMethod.POST,params = {"username","password","email"})
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
				user.setAvatar("/user/avatar/default.jpg");//设定用户默认头像
				user.setLoginName(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(null);
				user.setNick(username);
				user.setCreatedTime(new Date());
				user.setEmailAuth(true);
				user.setMobileAuth(false); 
				user.setHasPic(false);
				user.setSex("male");
				user.setType(UserType.NORMAL); 
				userService.createUser(user);
				
				user = userService.findUserByLoginName(username);
				
				
				//建立名片
				Card card = new Card();
				card.setUser_id(user.getId());
				card.setName(user.getNick());
				card.setEmail(user.getEmail());
				cardService.createCard(card);
				
				
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
	 * 手机号注册
	 * @param request
	 * @param username
	 * @param mobile
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "registerByMobile", method = RequestMethod.POST,params = {"username","mobile","password","code"})
	public Object registerByMobile(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("mobile") String mobile,@RequestParam("password") String password,@RequestParam("code") String code) {
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(mobile,password,code)) {
			if (!code.equals("888888")) {
				//code error
				resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_CODE_ERROR);
				resultModel.setData(Code.PHONE_CODE_ERROR.getMessage());
				return resultModel;
			}
			if (userService.countUsersByLoginName(username)>0) {
				//用户名已注册
				resultModel = ResultModelUtils.getResultModelByCode(Code.USER_NAME_USED);
				resultModel.setData("用户名已被注册");
				return resultModel;
			}
			if (userService.countUsersByMobile(mobile)>0) {
				//手机号已注册
				resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_USED);
				resultModel.setData("手机号已被注册");
				return resultModel;
			}
			if (RegexUtils.checkAll(username, password, null, mobile)) {
				User user = new User();
				user.setLoginName(username);
				user.setEmail(null);
				user.setPassword(password);
				user.setMobile(mobile);
				user.setNick(username);
				user.setCreatedTime(new Date());
				user.setEmailAuth(false);
				user.setMobileAuth(true); 
				user.setHasPic(false);
				user.setType(UserType.NORMAL); 
				userService.createUser(user);
				
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
