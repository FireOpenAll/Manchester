/**
 * 
 */
package com.galaxy.front.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.controller.UserController.AuthResultModel;

/**
 * @author luolishu
 *
 */
@RestController
@RequestMapping(value = "api/v1")
public class VerifyCodeController {
	
	@RequestMapping(value = "/verify_code", method = RequestMethod.GET)
	public Object verifycode() {
		ResultModel result=new ResultModel();
		result.setCode("420");
		AuthResultModel authModel=new AuthResultModel();
		result.setData(authModel);
		return result;
	}

	
	@RequestMapping(value = "/image_code", method = RequestMethod.GET)
	public Object imageverifycode() {
		ResultModel result=new ResultModel();
		result.setCode("420");
		AuthResultModel authModel=new AuthResultModel();
		result.setData(authModel);
		return result;
	}
}
