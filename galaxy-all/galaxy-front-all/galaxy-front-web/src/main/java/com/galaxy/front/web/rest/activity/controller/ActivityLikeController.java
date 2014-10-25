package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class ActivityLikeController {
	@Autowired
	private ActivityService activityService;
	
	/**
	 * @param :activity_id,user_id
	 * @return
	 */
	@RequestMapping("like")
	public Object setLikeActivity(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set like success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
	}
	
	@RequestMapping("unlike")
	public Object setUnlikeActivity(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("set unlike success");
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
	}
	
	
	/**
	 * 获取我参加过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getMyLikedActivity",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getLikedActivity(@RequestParam("user_id") long user_id,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
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
	}
	
	
	
	@RequestMapping(value = "like1",method = RequestMethod.POST,params = {"activity_id","user_id"})
	public Object setLikeActivity1(@RequestParam("activity_id") Long activity_id, @RequestParam("user_id") Long user_id){
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
	
	@RequestMapping(value = "unlike1",method = RequestMethod.POST,params = {"activity_id","user_id"})
	public Object setUnlikeActivity1(@RequestParam("activity_id") Long activity_id, @RequestParam("user_id") Long user_id){
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
	
	
	/**
	 * 获取我参加过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getMyLikedActivity1",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getLikedActivity1(@RequestParam("user_id") long user_id,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
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
	}
	
}
