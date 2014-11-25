package com.galaxy.front.web.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;

/*author:huangshanqi
 *time  :2014年11月19日 上午11:16:06
 *email :hsqmobile@gmail.com
 */
@Controller(value="webAvatarUploadController")
@RequestMapping("account")
public class AvatarUploadController {

	@RequestMapping(value="uploadAvatar")
	@ResponseBody
	public Object webUploadAvatar(){
		ResultModel resultModel = new ResultModel();
		resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
		
		return resultModel;
	}
}
