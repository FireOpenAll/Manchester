package com.galaxy.front.web.rest.tags.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*author:huangshanqi
 *time  :2014年10月26日 下午4:30:01
 *email :hsqmobile@gmail.com
 */



import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;

@RestController
@RequestMapping(value = "api/v1/user")
public class PeopleTagsController {

	/**
	 * 人标签控制器
	 */
	@RequestMapping(value = "tags",method = RequestMethod.GET,params ={"user_id"})
	public Object getPeoPleRecommendTags(@RequestParam("user_id") Long user_id){
		//推荐用户标签
		ResultModel resultModel = new ResultModel();
		
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		//Todo
		
		return resultModel;
	}
}
