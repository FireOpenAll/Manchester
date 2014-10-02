package com.galaxy.front.web.rest.activity.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Paginations;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.activity.HotItemModel;
import com.galaxy.front.web.rest.model.activity.HotItemModel.JoinedPeopleInfo;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class HotsController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "hots_activities", method = RequestMethod.GET)
	public Object getHotsActivities() {
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

		for (int i = 0; i < 10; i++) {
			recomment_activity.add(new ActivityModel("activity",1110001100L, 123456789L, "活动" + i, (float) (90.69 + i),
					(i % 2 == 0) ? true : false, (++i % 2 == 0) ? true : false, i + "组织者", new Date(), new Date(),
					new Contact("12345678901"), "活动摘要" + i, "/activity/" + i, photos, new LocationInfo(100.12 + i * 2,
							120.89 + i * 3, "北京市海淀区西土城路"), relative_user));
		}
		
		resultModel.setData(recomment_activity);

		return resultModel;
	}
}
