package com.galaxy.front.web.rest.user.controller.activity;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityCollectUser;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;

/*author:huangshanqi
 *time  :2014年12月10日 下午11:18:34
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/activity")
public class UserCollectActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value="getcollectedAct",method=RequestMethod.GET,params={"pageNum","pageSize"})
	public Object getUsercollectActivity(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
		ResultModel resultModel = new ResultModel();
		if(ParamUtils.isNotEmpty(pageNum,pageSize)){
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			if(pageNum <= 0){
				pageNum = 1;
			}
			if(pageSize <= 0 || pageSize > Constants.MAX_PAGESIZE){
				pageSize = Constants.PAGESIZE;
			}
			
			LoginUserModel loginUserModel = UserUtils.getLoginUser();
			ArrayList<ActivityModel> list = ActivityModel.ActListToActModelList(activityService.getUserCollectedActSortByTime(loginUserModel.getUserId(), (pageNum-1)*pageSize, pageSize));
			resultModel.setData(list);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			
		}
		
		return resultModel;
	}
	
	@RequestMapping(value="collect",method = RequestMethod.POST,params={"activityId"})
	public Object commentActivity(HttpServletRequest request,@RequestParam("activityId") Long activityId){
		ResultModel resultModel = new ResultModel();
		
		if(ParamUtils.isNotEmpty(activityId)){
			ActivityCollectUser collect = new ActivityCollectUser();
			collect.setCreatedTime(new Date());
			collect.setUpdatedTime(collect.getCreatedTime());
			collect.setActivityId(activityId);
			
			LoginUserModel loginUserModel = UserUtils.getLoginUser();
			collect.setUserId(loginUserModel.getUserId());
			
			if(activityService.collectActivity(collect)){
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("ok"));
			}else{
				resultModel = ResultModelUtils.getResultModelByCode(Code.COLLECT_FAIL);
				resultModel.setData(new StatusModel("fail"));
			}
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		
		return resultModel;
	}
	
	@RequestMapping(value="cancelCollect",method=RequestMethod.GET,params={"collectId"})
	public Object cancelCollect(@RequestParam("collectId") Long collectId){
		ResultModel resultModel = new ResultModel();
		if(ParamUtils.isNotEmpty(collectId)){
			if(activityService.cancelCollectActivity(collectId)){
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("ok"));
			}else{
				resultModel = ResultModelUtils.getResultModelByCode(Code.CANCEL_COLLECT_FAIL);
				resultModel.setData(new StatusModel("fail"));
			}
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		return resultModel;
	}
}
