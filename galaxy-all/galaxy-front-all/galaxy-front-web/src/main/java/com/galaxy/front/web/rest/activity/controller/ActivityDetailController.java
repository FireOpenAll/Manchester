package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityDetailModel;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.ticket.TicketService;
import com.galaxy.service.user.UserService;

/*author:huangshanqi
 *time  :2014年12月14日 下午3:18:48
 *email :hsqmobile@gmail.com
 */
@RestController("RestActivityDetailController")
@RequestMapping(value="api/v1/activity")
public class ActivityDetailController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="getDetail",method=RequestMethod.GET,params={"activityId"})
	public Object getActivityDetail(@RequestParam("activityId") Long activityId){
		
	    int showJoinedUserNum = 5;
		
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		Activity activity = activityService.getActivity(activityId);
		if(activity != null){
			ActivityDetailModel detail = new ActivityDetailModel();
			BeanUtils.copyProperties(activity, detail);
			detail.setActivityTags(Arrays.asList(activity.getTags().split(";")));
			detail.setActivityPics(Arrays.asList(activity.getPictures().split(";")));
			User user = userService.getUserById(activity.getOrganizerId());
			detail.setOrganizerNickName(user.getNick());
			
			List<User> users = activityService.getJoinedUsersSortInTime(activityId,0,showJoinedUserNum);
			if(users!=null){
				detail.setJoinedUser(UserModel.userListToUserModelList(users));
			}
			resultModel.setData(detail);
		}
		
		return resultModel;
	}
}
