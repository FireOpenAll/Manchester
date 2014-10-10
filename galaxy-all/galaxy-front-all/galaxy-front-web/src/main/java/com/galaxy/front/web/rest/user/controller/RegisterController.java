package com.galaxy.front.web.rest.user.controller;

import java.sql.Timestamp;
import java.util.Date;

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
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constans;
import com.galaxy.front.web.utils.EmailUtils;
import com.galaxy.front.web.utils.MD5Utils;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
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
	@Autowired
	private EmailUtils emailUtils;
	
	/**
	 * 客户端邮箱注册表单提交
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */
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
				user.setCreatedTime(new Timestamp(new Date().getTime()));
				
				if (userService.createUser(user)) {
					String code = MD5Utils.encode2String(email);

					StringBuilder stringBuilder = new StringBuilder("");
					stringBuilder.append("欢迎注册galaxy，点击以下完成邮箱验证!").append("\n");
					stringBuilder.append(Constans.localhost);
					stringBuilder.append("api/v1/email/verify?email=").append(email);
					stringBuilder.append("&code=").append(code);
					stringBuilder.append("\n");
					
					emailUtils.sendMail("galaxy 邮箱验证", stringBuilder.toString(), email);
					
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData("email register success");
				}else {
					resultModel = ResultModelUtils.getResultModelByCode(Code.REGISTER_ERROR);
					resultModel.setData("email register fail");
				}
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		return resultModel;
	}
	
}
