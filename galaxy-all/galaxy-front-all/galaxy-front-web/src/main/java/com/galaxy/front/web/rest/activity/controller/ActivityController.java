package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.GoldTimeModel;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.CategoryModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.service.activity.ActivityService;

@RestController(value = "restActivitiController")
@RequestMapping(value = "api/v1/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 发现页面 获取活动热门分类
	 * 
	 * @return
	 */
	@RequestMapping(value = "hot_category", method = RequestMethod.GET)
	public Object getHotActivityCategories() {
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("get host activity category");

		ArrayList<CategoryModel> interest_list = new ArrayList<CategoryModel>();
		for (int i = 0; i < 5; i++) {
			interest_list
					.add(new CategoryModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (30 + i) + ".jpg", "兴趣介绍"));
		}

		resultModel.setData(interest_list);
		return resultModel;
	}

	/**
	 * 发现页面 获取黄金时段
	 * 
	 * @return
	 */
	@RequestMapping(value = "gold_time", method = RequestMethod.GET)
	public Object getGoldTimes() {
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("get host activity category");

		ArrayList<GoldTimeModel> interest_list = new ArrayList<GoldTimeModel>();
		for (int i = 0; i < 5; i++) {
			interest_list.add(new GoldTimeModel(10000000 + i, new Photo("/interest/cover/" + (20 + i) + ".jpg",
					"/interest/cover/" + (20 + i) + ".jpg", "/interest/cover/" + (20 + i) + ".jpg"), "时段" + i));
		}

		resultModel.setData(interest_list);
		return resultModel;
	}

	/**
	 * 发现页面 获取热门活动（4个） 
	 * 算法推荐
	 * @return
	 */
	@RequestMapping(value = "rec_hot_activities", method = RequestMethod.GET)
	public Object getHotActivitys() {
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("get host activity category");

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
					.add(new CategoryModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (20 + i) + ".jpg", "兴趣介绍"));
		}

		for (int i = 0; i < 4; i++) {
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
	 * 发现页面 获取活动热门分类
	 * 
	 * @return
	 */
	@RequestMapping(value = "hot_category1", method = RequestMethod.GET)
	public Object getHotActivityCategories1() {
		/**
		 * sql
		 */
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("get host activity category");

		ArrayList<CategoryModel> interest_list = new ArrayList<CategoryModel>();
		for (int i = 0; i < 5; i++) {
			interest_list
					.add(new CategoryModel(10000000 + i, "兴趣" + i, "/interest/cover/" + (30 + i) + ".jpg", "兴趣介绍"));
		}

		resultModel.setData(interest_list);
		return resultModel;
	}


}
