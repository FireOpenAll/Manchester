package com.galaxy.front.web.rest.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class ActivityLikeController {
	@Autowired
	private ActivityService activityService;
	
	/**
	 * @param :activity_id,user_id
	 * @return
	 */
	@RequestMapping("like")
	public Object setLikeActivity(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set like success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
	}
	
	@RequestMapping("unlike")
	public Object setUnlikeActivity(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set unlike success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
	}
}
