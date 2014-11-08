package com.galaxy.front.web.rest.activity.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Paginations;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.activity.HotItemModel;
import com.galaxy.front.web.rest.model.activity.HotItemModel.JoinedPeopleInfo;
import com.galaxy.front.web.rest.model.interest.CategoryModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class HotsController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "hots_activities1", method = RequestMethod.GET)
	public Object getHotsActivities1() {
		/*
		 * Paginations<HotItemModel> paginations = new
		 * Paginations<HotItemModel>(); paginations.setPageNum(1);
		 * paginations.setPageSize(10); List<HotItemModel> dataList = new
		 * ArrayList<HotItemModel>(); for (int i = 0; i < 10; i++) {
		 * HotItemModel model = new HotItemModel(); model.setTitle("title" + i);
		 * model.setPicUrl("/activity/activityId/pic" + i + ".jpg");
		 * model.setActivityId((long) i); model.setLike(23);
		 * model.setStartTime(new Date()); model.setEndTime(new Date());
		 * model.setAddress("北京市朝阳区"); model.setTitle("title" + i);
		 * JoinedPeopleInfo joinedInfo = new JoinedPeopleInfo();
		 * joinedInfo.setTatal(121); joinedInfo.setAvatars(new String[] {
		 * "/avatars/userid/avatar.jpg", "/avatars/userid2/avatar.jpg" });
		 * model.setJoinedInfo(joinedInfo); dataList.add(model); }
		 * paginations.setDatas(dataList);
		 * 
		 * return paginations;
		 */
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get hots activities success");

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

		ArrayList<CategoryModel> interest_list = new ArrayList<CategoryModel>();
		for (int i = 0; i < 4; i++) {
			interest_list
					.add(new CategoryModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (10 + i) + ".jpg", "兴趣介绍"));
		}

		for (int i = 0; i < 10; i++) {
			// recomment_activity.add(new ActivityModel("activity",
			// (long)(11110000+i), "活动名"+i*2, price, like, like_count, join,
			// join_count, comment_count, owner, start_time, end_time, contact,
			// summary, url, photo_list, locationInfo, relative_user,
			// interest_list))

			recomment_activity.add(new ActivityModel("activity", (long) 11110000 + i, "活动名" + i * 2,
					(float) (10.111 + i), (i % 2 == 0) ? true : false, 100 * i, (i % 2 != 0) ? true : false, 200 * i,
					300 * i, "组织者 " + i + " 号", new Date(), new Date(), new Contact("1234567890" + i), "活动" + i + "摘要",
					"活动" + i + "url", photos, new LocationInfo(100.12 + i * 2, 120.89 + i * 3, "北京市海淀区西土城路"),
					relative_user, interest_list));

		}

		resultModel.setData(recomment_activity);

		return resultModel;
	}

	/**
	 * 参与人数排序
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "hots_activities", method = RequestMethod.GET, params = { "pageNum", "pageSize" })
	public Object getHotsActivities(@RequestParam("user_id") Long userId,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		/*
		 * Paginations<HotItemModel> paginations = new
		 * Paginations<HotItemModel>(); paginations.setPageNum(1);
		 * paginations.setPageSize(10); List<HotItemModel> dataList = new
		 * ArrayList<HotItemModel>(); for (int i = 0; i < 10; i++) {
		 * HotItemModel model = new HotItemModel(); model.setTitle("title" + i);
		 * model.setPicUrl("/activity/activityId/pic" + i + ".jpg");
		 * model.setActivityId((long) i); model.setLike(23);
		 * model.setStartTime(new Date()); model.setEndTime(new Date());
		 * model.setAddress("北京市朝阳区"); model.setTitle("title" + i);
		 * JoinedPeopleInfo joinedInfo = new JoinedPeopleInfo();
		 * joinedInfo.setTatal(121); joinedInfo.setAvatars(new String[] {
		 * "/avatars/userid/avatar.jpg", "/avatars/userid2/avatar.jpg" });
		 * model.setJoinedInfo(joinedInfo); dataList.add(model); }
		 * paginations.setDatas(dataList);
		 * 
		 * return paginations;
		 */
		/*
		 * ResultModel resultModel = new ResultModel();
		 * resultModel.setCode("20000");
		 * resultModel.setMessage("get hots activities success");
		 * 
		 * ArrayList<ActivityModel> recomment_activity = new
		 * ArrayList<ActivityModel>();
		 * 
		 * ArrayList<UserModel> relative_user = new ArrayList<UserModel>(); for
		 * (int i = 1; i < 6; i++) { relative_user.add(new UserModel(100000000L,
		 * "/user/avatar/" + 10 * i + ".jpg", "name" + i, (i % 2 == 0) ? "male"
		 * : "female")); }
		 * 
		 * ArrayList<Photo> photos = new ArrayList<Photo>(); for (int i = 1; i <
		 * 4; i++) { photos.add(new Photo("/interest/cover/" + (10 + i) +
		 * ".jpg", "/interest/cover/" + (10 + i) + ".jpg", "/interest/cover/" +
		 * (10 + i) + ".jpg")); }
		 * 
		 * ArrayList<CategoryModel> interest_list = new
		 * ArrayList<CategoryModel>(); for (int i = 0; i < 4; i++) {
		 * interest_list.add(new CategoryModel(10000000+i, "兴趣"+i,
		 * "/interest/cover/" + (10 + i) + ".jpg", "兴趣介绍")); }
		 * 
		 * for (int i = 0; i < 10; i++) { //recomment_activity.add(new
		 * ActivityModel("activity", (long)(11110000+i), "活动名"+i*2, price, like,
		 * like_count, join, join_count, comment_count, owner, start_time,
		 * end_time, contact, summary, url, photo_list, locationInfo,
		 * relative_user, interest_list))
		 * 
		 * recomment_activity.add( new ActivityModel("activity",
		 * (long)11110000+i, "活动名"+i*2, (float)(10.111+i), (i%2==0)?true:false,
		 * 100*i, (i%2!=0)?true:false, 200*i,300*i, "组织者 "+i+" 号", new Date(),
		 * new Date(), new Contact("1234567890"+i), "活动"+i+"摘要", "活动"+i+"url",
		 * photos, new LocationInfo(100.12 + i * 2,120.89 + i * 3,
		 * "北京市海淀区西土城路"), relative_user, interest_list) );
		 * 
		 * }
		 * 
		 * resultModel.setData(recomment_activity);
		 * 
		 * return resultModel;
		 */

		ResultModel resultModel = new ResultModel();
		
		
		if (ParamUtils.isNotEmpty(pageNum, pageSize)) {
			if (pageSize > Constants.MAX_PAGESIZE) {
				pageSize = Constants.MAX_PAGESIZE;
			}
			if (pageSize <= 0) {
				pageSize = Constants.PAGESIZE;
			}
			if (pageNum <= 0) {
				pageNum = 1;
			}
			
			List<Activity> activities = activityService.getActsSortByJionedNum((pageNum-1)*pageSize, pageSize);
			ArrayList<ActivityModel> results = new ArrayList<ActivityModel>();
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			if (activities == null || activities.size() == 0) {
				return resultModel;
			}
			for (Activity activity : activities) {
				ActivityModel activityModel = new ActivityModel();

				activityModel.setFeed_type("activity");

				activityModel.setActivity_id(activity.getId());
				activityModel.setActivity_name(activity.getTitle());
				activityModel.setPrice(activity.getPrice());
				
				if (userId != null) {
					// 用户是否已经点赞
					boolean hasLiked = activityService.isUserLikedActivity(userId, activity.getId());
					activityModel.setLike(hasLiked);

					activityModel.setLike_count(activity.getLiked_num());
					// 用户是否已经参加
					boolean hasJoined = activityService.isUserJoinedActivity(userId, activity.getId());
					activityModel.setJoin(hasJoined);
				}else {
					activityModel.setLike(false);
					activityModel.setJoin(false);
				}
				
				

				activityModel.setJoin_count(activity.getJoinedNum());

				// 活动总评论数
				int comment_count = activityService.getActComNum(activity.getId());
				activityModel.setComment_count(comment_count);

				activityModel.setOwner(activity.getSponsor());
				activityModel.setStart_time(activity.getStartTime());
				activityModel.setEnd_time(activity.getEndTime());
				activityModel.setContact(new Contact(activity.getPhone()));
				activityModel.setSummary(activity.getDescription());
				activityModel.setUrl(activity.getRefUrl());

				// 海报
				ArrayList<Photo> photoList = new ArrayList<Photo>();
				for (String photo : activity.getHaibao_urls().split(";")) {
					photoList.add(new Photo(photo, photo, photo));
				}
				activityModel.setPhoto_list(photoList);

				// 地点信息
				LocationInfo locationInfo = new LocationInfo();
				locationInfo.setLongitude(activity.getLongtitude());
				locationInfo.setLatitude(activity.getLatitude());
				locationInfo.setAddress(activity.getAddress());
				activityModel.setLocationInfo(locationInfo);

				// 活动相关参与人员,推荐相关
				int num = 6;// 暂定6个
				List<User> users = activityService.listTopActJionUser(activity.getId(), num);
				if (users != null) {
					ArrayList<UserModel> list = new ArrayList<UserModel>();
					for (User user : users) {
						UserModel userModel = new UserModel();
						userModel.setUserid(user.getId());
						userModel.setAvatar(user.getAvatar());
						userModel.setName(user.getLoginName());
						userModel.setGender(user.getSex());

						list.add(userModel);
					}
					activityModel.setRelative_user(list);
				}

				// 活动标签

				// 修改活动兴趣
				ArrayList<CategoryModel> interest_list = new ArrayList<CategoryModel>();
				for (int i = 0; i < 4; i++) {
					interest_list.add(new CategoryModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (20 + i) + ".jpg",
							"兴趣介绍"));
				}
				activityModel.setInterest_list(interest_list);

				// 活动分类

				results.add(activityModel);
			}

			resultModel.setData(results);
			return resultModel;
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			return resultModel;
		}

	}

}
