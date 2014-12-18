package com.galaxy.front.web.rest.user.controller.activity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.utils.Code;
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

}
