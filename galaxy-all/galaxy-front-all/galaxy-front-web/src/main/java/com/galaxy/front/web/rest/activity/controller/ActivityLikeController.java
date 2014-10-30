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
import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class ActivityLikeController {
	@Autowired
	private ActivityService activityService;
	
	
	/**
	 * 获取我like过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getMyLikedActivity",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getLikedActivity(@RequestParam("user_id") long userId,@RequestParam("until_id") long untilId,@RequestParam("pageSize") int pageSize){
		/*
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("getMyLikedActivity success");

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
			List<Activity> activities = activityService.getUserLikedActByUntilId(userId, untilId, pageSize);
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
	
	
	
	@RequestMapping(value = "like",method = RequestMethod.POST,params = {"activity_id","user_id"})
	public Object setLikeActivity(@RequestParam("activity_id") Long activity_id, @RequestParam("user_id") Long user_id){
		
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set like success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
		 */
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(activity_id,user_id)) {
			ActivityLikedUsers activityLikedUsers = new ActivityLikedUsers();
			activityLikedUsers.setActivityId(activity_id);
			activityLikedUsers.setCreatedTime(new Date());
			activityLikedUsers.setUserId(user_id);
			if (activityService.likeActivity(activityLikedUsers)) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("ok"));
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
				resultModel.setData(new StatusModel("like failed"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("like failed"));
		}
		
		return resultModel;
	}
	
	@RequestMapping(value = "unlike",method = RequestMethod.POST,params = {"activity_id","user_id"})
	public Object setUnlikeActivity(@RequestParam("activity_id") Long activity_id, @RequestParam("user_id") Long user_id){
		/*
		 ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set unlike success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
		 */
		
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(activity_id,user_id)) {
			
			if (activityService.cancelLiked(user_id, activity_id)) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("ok"));
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
				resultModel.setData(new StatusModel("unlike failed"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("unlike failed"));
		}
		
		return resultModel;
	}
	
	
}
