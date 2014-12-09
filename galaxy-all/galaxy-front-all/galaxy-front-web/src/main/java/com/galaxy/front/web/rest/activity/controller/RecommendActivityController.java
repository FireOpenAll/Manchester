package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;

/*author:huangshanqi
 *time  :2014年12月7日 上午10:25:46
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/activity")
public class RecommendActivityController {
	
	@Autowired
	private ActivityService activityService;

	/**
	 * app 推荐tab
	 */
	@RequestMapping(value="recommendTabs",method = RequestMethod.GET,params={"pageNum","pageSize"})
	public Object getRecommendActivityTab(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
		ResultModel resultModel = new ResultModel();
		if(pageNum <= 0){
			pageNum = 1;
		}
		if(pageSize <= 0 || pageSize > Constants.MAX_PAGESIZE){
			pageSize = Constants.PAGESIZE;
		}
		List<Activity> activitys = activityService.getActivitySortInCommentNum((pageNum-1)*pageSize, pageSize);
		ArrayList<ActivityModel> models = ActivityModel.ActListToActModelList(activitys);
		
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(models);
		
		return resultModel;
	}
}
