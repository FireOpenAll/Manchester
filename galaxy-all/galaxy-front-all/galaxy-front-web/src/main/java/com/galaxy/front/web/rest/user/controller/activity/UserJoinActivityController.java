package com.galaxy.front.web.rest.user.controller.activity;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.LoginUserModel;
/*author:huangshanqi
 *time  :2014年12月10日 下午11:16:33
 *email :hsqmobile@gmail.com
 */
import com.galaxy.service.user.UserUtils;


@RestController
@RequestMapping("api/v1/user/activity")
public class UserJoinActivityController {
	
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value="getJoinedAct",method = RequestMethod.GET,params = {"pageNum","pageSize"})
	public Object getUserPublishActivity(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		if(pageNum <= 0){
			pageNum = 1;
		}
		if(pageSize <= 0 || pageSize > Constants.MAX_PAGESIZE){
			pageSize = Constants.PAGESIZE;
		}
		LoginUserModel loginUserModel = UserUtils.getLoginUser();
		ArrayList<ActivityModel>  list= ActivityModel.ActListToActModelList(activityService.getUserJoinedActs(loginUserModel.getUserId(),(pageNum-1)*pageSize, pageSize)) ;
		
		resultModel.setData(list);
		return resultModel;
	}
	
	@RequestMapping(value="join",method=RequestMethod.POST,params={"activityId"})
	public Object joinActivity(@RequestParam("activityId") Long activityId){
		ResultModel resultModel = new ResultModel();
		ActivityUser activityUser = new ActivityUser();
		activityUser.setActivityId(activityId);	
		activityUser.setCreatedTime(new Date());
		activityUser.setUpdatedTime(activityUser.getCreatedTime());
		LoginUserModel loginUser = UserUtils.getLoginUser();
		activityUser.setUserId(loginUser.getUserId());
		activityUser.setNum(1);
		activityUser.setUsername(loginUser.getNickName());
		if(activityService.joinActivity(activityUser)){
			resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("ok"));
		}else{
			resultModel=ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	@RequestMapping(value="unjoin",method=RequestMethod.POST,params={"activityId"})
	public Object unjoinActivity(@RequestParam("activityId") Long activityId){
		ResultModel resultModel = new ResultModel();
		
		if(activityService.unjoinActivity(UserUtils.getLoginUser().getUserId(),activityId)){
			resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("unjoin activity ok"));
		}else{
			resultModel=ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	

}
