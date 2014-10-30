/**
 * 
 */
package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.UserService;

/**
 * @author luolishu
 * 
 */

@RestController(value = "RestActivityJoinController")
@RequestMapping(value = "/api/v1/activity")
public class ActivityJoinController {
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;
	
	/**
	 * 获取我参加过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getMyJoinedActivity",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getJoinedActivity(@RequestParam("user_id") long user_id,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("getMyJoinedActivity success");

		ArrayList<ActivityModel> recomment_activity = new ArrayList<ActivityModel>();

		ArrayList<UserModel> relative_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			relative_user.add(new UserModel(100000000L, "/user/avatar/" + 10 * i + ".jpg", "name" + i,
					(i % 2 == 0) ? "male" : "female"));
		}

		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 1; i < 4; i++) {
			photos.add(new Photo("/interest/cover/" + (10 + i) + ".jpg", "/interest/cover/" + (10 + i) + ".jpg",
					"/interest/cover/" + (10 + i) + ".jpg"));
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
	
	//参加活动
	@RequestMapping(value = "join",method = RequestMethod.POST,params = {"user_id","activity_id","username","num",})
	public Object jion(@RequestParam("user_id") Long user_id,@RequestParam("activity_id") Long activity_id){
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,activity_id)) {
			if (activityService.joinActivity(activity_id, user_id)) {
				//参加成功
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData("参加活动成功");
			}else {
				//参加失败
				resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
				resultModel.setData("活动不存在或用户不存在");
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("请输入正确的参数");
		}
		
		return resultModel;
	}
	
	//退出活动
	
	
	
	/**
	 * 获取我参加过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getMyJoinedActivity1",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getJoinedActivity1(@RequestParam("user_id") long user_id,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
		/*
		 * sql
		 */
		ResultModel resultModel = new ResultModel();
		
		List<Activity> activityList = activityService.listAllJoinedActs(user_id);
		
		resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
		if (activityList == null|| activityList.size() <=0) {
			return resultModel;
		}
		 
		ArrayList<ActivityModel> activityModelList = new ArrayList<ActivityModel>();
		
		for(Activity activity : activityList){
			ActivityModel activityModel = new ActivityModel();
			
			activityModel.setFeed_type("activity");
			
			activityModel.setActivity_id(activity.getId());
			activityModel.setActivity_name(activity.getTitle());
			activityModel.setPrice(activity.getPrice());
			//用户是否已经点赞
			boolean hasLiked = activityService.isUserLikedActivity(user_id, activity.getId());
			activityModel.setLike(hasLiked);
			
			activityModel.setLike_count(activity.getLiked_num());
			//用户是否已经参加
			boolean hasJoined = activityService.isUserJoinedActivity(user_id, activity.getId());
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
			
			
			
			activityModelList.add(activityModel);
		}
		
		resultModel.setData(activityModelList);
		
		return resultModel;
	}
	

}
