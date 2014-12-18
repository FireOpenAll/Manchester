package com.galaxy.front.web.rest.user.controller.activity;

import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringBuilder;
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
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;
import com.mysql.fabric.xmlrpc.base.Array;

/*author:huangshanqi
 *time  :2014年12月10日 下午11:16:54
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/activity")
public class UserPublishActivityController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value="getPublishedAct",method = RequestMethod.GET,params = {"pageNum","pageSize"})
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
		ArrayList<ActivityModel>  list= ActivityModel.ActListToActModelList(activityService.getUserPublishActivity(loginUserModel.getUserId(),(pageNum-1)*pageSize, pageSize)) ;
		
		resultModel.setData(list);
		return resultModel;
		
	}
}
