package com.galaxy.front.web.rest.user.controller.activity;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.comment.CommentModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

/*author:huangshanqi
 *time  :2014年12月10日 下午11:18:14
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/activity")
public class UserCommentActivityController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="getCommentedAct",method=RequestMethod.GET,params={"pageNum","pageSize"})
	public Object getUserCommentActivity(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
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
			ArrayList<ActivityModel> list = ActivityModel.ActListToActModelList(activityService.getUserComedActSortByTime(loginUserModel.getUserId(), (pageNum-1)*pageSize, pageSize));
			resultModel.setData(list);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	@RequestMapping(value="comment",method = RequestMethod.POST,params={"activityId","content"})
	public Object commentActivity(HttpServletRequest request,@RequestParam("activityId") Long activityId,@RequestParam("content") String content){
		ResultModel resultModel = new ResultModel();
		
		if(ParamUtils.isNotEmpty(activityId,content)){
			ActivityComment comment = new ActivityComment();
			comment.setCreatedTime(new Date());
			comment.setUpdatedTime(comment.getCreatedTime());
			comment.setActivityId(activityId);
			comment.setContent(content);
			if(request.getParameter("targetId") == null){
				comment.setCommentType(0);
			}else{
				comment.setCommentType(1);
				comment.setTargetId(Long.valueOf(request.getParameter("targetId")));
			}
			LoginUserModel loginUserModel = UserUtils.getLoginUser();
			comment.setUserId(loginUserModel.getUserId());
			
			activityService.commentActivity(comment);
			
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(comment);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	
	
	@RequestMapping(value="deleteComment",method=RequestMethod.GET,params={"commontId"})
	public Object deleteComment(@RequestParam("commontId") Long commontId){
		ResultModel resultModel = new ResultModel();
		if(ParamUtils.isNotEmpty(commontId)){
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			activityService.deleteComment(commontId);
			resultModel.setData(new StatusModel("ok"));
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		return resultModel;
	}
	
}
