/**
 * 
 */
package com.galaxy.front.web.rest.upload.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.galaxy.front.web.rest.model.ResultModel;

/**
 * @author luolishu
 *
 */

@RestController(value = "RestAvatarUploadController")
@RequestMapping("api/v1/user/")
public class AvatarUploadController {
	
	@RequestMapping(value = "changeAvatar",method = RequestMethod.POST)
	public Object changeAvatar(@RequestParam("avatar")MultipartFile avatar){
		ResultModel resultModel = new ResultModel();
		
		
		
		return resultModel;
	}

}
