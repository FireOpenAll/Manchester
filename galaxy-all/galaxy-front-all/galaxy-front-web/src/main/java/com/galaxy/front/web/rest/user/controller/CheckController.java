/**
 * 
 */
package com.galaxy.front.web.rest.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.interceptor.IgnoreAuth;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.RegexUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.UserService;

/**
 * @author luolishu
 * 
 */
@RestController(value = "RestCheckController")
@RequestMapping(value = "api/v1/check")
@IgnoreAuth
public class CheckController {
	
	/*注册检验控制器，注册时检验邮箱、手机号、用户名是否可以注册*/
	
	@Autowired
	UserService userService;
	
	
	/**手机端检验邮箱是否可用
	 * @param request
	 * @param email
	 * @return ResultModel
	 */
	@RequestMapping(value = "email",method=RequestMethod.GET,params={"email"})
	public Object checkEmail(@RequestParam("email")String email) {
		ResultModel resultModel = new ResultModel();
		if (RegexUtils.checkEmail(email)) {
			if (userService.isEmailExisted(email)) {
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
	
	/**手机端检验用户名是否可用
	 * @param request
	 * @param username
	 * @return ResultModel
	 */
	@RequestMapping(value = "username",method=RequestMethod.GET,params={"username"})
	public Object checkUsername(@RequestParam("username")String username) {
		ResultModel resultModel = new ResultModel();
		if (RegexUtils.checkName(username)) {
			if (userService.isLoginNameExisted(username)) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.USER_NAME_USED);
				resultModel.setData(new StatusModel("username unusable"));
			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("username usable"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.USER_NAME_FORMAT_ERROR);
			resultModel.setData(new StatusModel("username format error"));
		}
		
		return resultModel;
	}
 
	/**手机端检验手机号是否可用
	 * @param request
	 * @param mobile
	 * @return ResultModel
	 */
	@RequestMapping(value = "mobile",method=RequestMethod.GET,params={"mobile"})
	public Object checkMobile(@RequestParam("mobile")String mobile) {
		ResultModel resultModel = new ResultModel();
		if (RegexUtils.checkPhone(mobile)) {
			if (userService.isMobileExisted(mobile)) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_USED);
				resultModel.setData(new StatusModel("mobile unusable"));
			} else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("mobile usable"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PHONE_FORMAT_ERROR);
			resultModel.setData(new StatusModel("mobile format error"));
		}
		
		return resultModel;
	}
}
