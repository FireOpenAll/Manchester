package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.CommentModel;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.UserService;

@RestController(value = "restActivityCommentsController")
@RequestMapping(value = "api/v1/activity")
public class ActivityCommentsController {
	
	@Autowired
	ActivityService activityService;
	@Autowired 
	UserService userService;

	/**
	 * @param : activity_id, until_id, count
	 * 
	 * @return ResultModel
	 */
	@RequestMapping(value = "comment", method = RequestMethod.GET,params = {"activity_id","until_id","count"})
	public Object getCommentByActId(@RequestParam("activity_id") Long activityId,@RequestParam("until_id") Long untilId,int count) {

		/*
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("get comment success");

		ArrayList<CommentModel> commentModels = new ArrayList<CommentModel>();
		for (int i = 0; i < 10; i++) {
			commentModels.add(new CommentModel((long) 1010101011, new UserModel((long) 111110000 + i,
					"/interest/cover/" + (30 + i) + ".jpg", "用户名" + i, (i % 2 == 0) ? "male" : "female"), "回复内容" + i,
					new Date()));
		}

		resultModel.setData(commentModels);
		return resultModel;
		*/
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(activityId,untilId,count)) {
			if (count > Constants.MAX_PAGESIZE) {
				count = Constants.MAX_PAGESIZE;
			}
			if (count <= 0) {
				count = Constants.PAGESIZE;
			}
			List<ActivityComment>  list = activityService.getActComByUntilId(activityId, untilId, count);
			if (list == null) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
				resultModel.setData("can not get commment");
				return resultModel;
			}
			ArrayList<CommentModel> results = new ArrayList<CommentModel>();
			for(ActivityComment activityComment : list){
				User user = userService.getUser(activityComment.getUserId());
				if (user != null) {
					UserModel userModel = new UserModel();
					userModel.setAvatar(user.getAvatar());
					userModel.setUserid(user.getId());
					userModel.setGender(user.getSex());
					userModel.setName(user.getLoginName());
					
					CommentModel commentModel = new CommentModel();
					commentModel.setAuthor(userModel);
					commentModel.setcomment_id(activityComment.getId());
					commentModel.setContent(activityComment.getContent());
					commentModel.setCreate_time(activityComment.getReplyTime());
					
					results.add(commentModel);
				}
			}
			return results;
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(Code.PARAMS_ERROR.getMessage());
			return resultModel;
		}
	}

	/**
	 * @param :activity_id,user_id,content
	 * @return
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST,params = {"activity_id","user_id","content","target_id"})
	public Object postCommentByActId(@RequestParam("activity_id") Long activityId,@RequestParam("user_id") Long userId,@RequestParam("target_id") Long targetId,@RequestParam("content") String content) {
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("post comment success");
		CommentModel commentModel=  new CommentModel(111100001, new UserModel(101010101, "/interest/cover/30.jpg", "name", "male"), "评论内容", new Date());
		resultModel.setData(commentModel);
		return resultModel;
		*/
		
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(activityId,userId,content)) {
			ActivityComment activityComment = new ActivityComment();
			activityComment.setActivityId(activityId);
			activityComment.setUserId(userId);
			activityComment.setTargetId(targetId);
			activityComment.setCreatedTime(new Date());
			
			activityComment = activityService.Comment(activityComment);
			if (activityComment == null) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.COMMENT_FIAL);
				return resultModel;
			}
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(activityComment);
		    return resultModel;
			
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			return resultModel;
		}
	}
	
	/**
	 * 获取我评论过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getCommentedActivity",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getLikedActivity(@RequestParam("user_id") long userId,@RequestParam("until_id") long untilId,@RequestParam("pageSize") int pageSize){
    /*
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("getCommentedActivity success");
		ArrayList<ActivityModel> recomment_activity = new ArrayList<ActivityModel>();
		ArrayList<UserModel> relative_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			relative_user.add(new UserModel(100000000L, "/user/avatar/" + 10 * i + ".jpg", "name" + i,
					(i % 2 == 0) ? "male" : "female"));
		}
		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 1; i < 4; i++) {
			photos.add(new Photo("/interest/cover/" + (20 + i) + ".jpg", "/interest/cover/" + (20 + i) + ".jpg",
					"/interest/cover/" + (20 + i) + ".jpg"));
		}
		ArrayList<InterestModel> interest_list = new ArrayList<InterestModel>();
		for (int i = 0; i < 4; i++) {
			interest_list
					.add(new InterestModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (20 + i) + ".jpg", "兴趣介绍"));
		}
		for (int i = 0; i < 10; i++) {
			recomment_activity.add(new ActivityModel("activity", (long) 11110000 + i, "活动名" + i * 2,
					(float) (10.111 + i), (i % 2 == 0) ? true : false, 100 * i, (i % 2 != 0) ? true : false, 200 * i,
					300 * i, "组织者 " + i + " 号", new Date(), new Date(), new Contact("1234567890" + i), "活动" + i + "摘要",
					"活动" + i + "url", photos, new LocationInfo(100.12 + i * 2, 120.89 + i * 3, "北京市海淀区西土城路"),
					relative_user, interest_list));
		}
		resultModel.setData(recomment_activity);
		
		return resultModel;
		
		*/
		
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(userId,untilId,pageSize)) {
			if (pageSize > Constants.MAX_PAGESIZE) {
				pageSize = Constants.MAX_PAGESIZE;
			}
			if (pageSize <= 0) {
				pageSize = Constants.PAGESIZE;
			}
			List<Activity> activities = activityService.getUserComedActByUntilId(userId, untilId, pageSize);
			ArrayList<ActivityModel> results = new ArrayList<ActivityModel>();
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			if (activities == null) {
			    return resultModel;	
			}
			for(Activity activity : activities){
				ActivityModel activityModel = new ActivityModel();
				
				activityModel.setFeed_type("activity");
				
				activityModel.setActivity_id(activity.getId());
				activityModel.setActivity_name(activity.getTitle());
				activityModel.setPrice(activity.getPrice());
				//用户是否已经点赞
				boolean hasLiked = activityService.isUserLikedActivity(userId, activity.getId());
				activityModel.setLike(hasLiked);
				
				activityModel.setLike_count(activity.getLiked_num());
				//用户是否已经参加
				boolean hasJoined = activityService.isUserJoinedActivity(userId, activity.getId());
				activityModel.setJoin(hasJoined);
				
				activityModel.setJoin_count(activity.getJoinedNum());
				
				//活动总评论人数
				int comment_count = activityService.getCommUserNum(activity.getId());
				activityModel.setComment_count(comment_count);
				
				activityModel.setOwner(activity.getSponsor());
				activityModel.setStart_time(activity.getStartTime());
				activityModel.setEnd_time(activity.getEndTime());
				activityModel.setContact(new Contact(activity.getPhone()));
				activityModel.setSummary(activity.getDescription());
				activityModel.setUrl(activity.getRefUrl());
				
				//海报
				ArrayList<Photo> photoList = new ArrayList<Photo>();
				for(String photo:activity.getHaibao_urls().split(";")){
					photoList.add(new Photo(photo, photo, photo));
				}
				activityModel.setPhoto_list(photoList);
				
				//地点信息
				LocationInfo locationInfo = new LocationInfo();
				locationInfo.setLongitude(activity.getLongtitude());
				locationInfo.setLatitude(activity.getLatitude());
				locationInfo.setAddress(activity.getAddress());
				activityModel.setLocationInfo(locationInfo);
				
				//活动相关参与人员,推荐相关
				int num = 6;//暂定6个
				List<User> users =  activityService.listTopActJionUser(activity.getId(), num);
				List<UserModel> list = new ArrayList<UserModel>();
				for(User user : users){
					UserModel userModel = new UserModel();
					userModel.setUserid(user.getId());
					userModel.setAvatar(user.getAvatar());
					userModel.setName(user.getLoginName());
					userModel.setGender(user.getSex());
					
					list.add(userModel);
				}
				
				//活动标签
				
				
				//修改活动兴趣
				
				//活动分类
				
				
				
				results.add(activityModel);
			}
			
			resultModel.setData(results);
			return resultModel ;
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			return resultModel;
		}
		
	}
	

}
