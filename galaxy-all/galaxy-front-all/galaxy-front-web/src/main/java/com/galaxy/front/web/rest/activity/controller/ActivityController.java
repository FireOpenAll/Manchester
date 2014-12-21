package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.comment.CommentModel;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.UserService;

/*author:huangshanqi
 *time  :2014年12月16日 下午7:36:56
 *email :hsqmobile@gmail.com
 */
@RestController("RestActivityController")
@RequestMapping("api/v1/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="getAllComment",method=RequestMethod.GET,params={"activityId"})
	public Object getComment(@RequestParam("activityId") Long activityId){
		ResultModel resultModel = new ResultModel();
		
		if(ParamUtils.isNotEmpty(activityId)){
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			ArrayList<ActivityComment> list = activityService.getAllActComSortByTime(activityId);
			if(list != null){
				ArrayList<CommentModel> comments = new ArrayList<CommentModel>();
				for(ActivityComment activityModel:list){
					User user = userService.getUserById(activityModel.getUserId());
					if(user != null){
						CommentModel comment = new CommentModel();
						comment.setTime(activityModel.getUpdatedTime());
						comment.setId(activityModel.getId());
						comment.setActivityId(activityModel.getActivityId());
						comment.setContent(activityModel.getContent());
						comment.setUserId(activityModel.getUserId());
						comment.setAvatar(user.getAvatar());
						comment.setNickName(user.getNick());
						comments.add(comment);
					}
				}
				resultModel.setData(comments);
			}
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	@RequestMapping(value="getAllJoinedUser",method=RequestMethod.GET,params={"activityId"})
	public Object getActivityJoinUser(@RequestParam("activityId") Long activityId){
		ResultModel resultModel = new ResultModel();
		resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
		List<User> users = activityService.getAllJoinedUsersSortInTime(activityId);
		if(users!=null){
			resultModel.setData(UserModel.userListToUserModelList(users));
		}
		return resultModel;
	}
	
}
