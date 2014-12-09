package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value ="api/v1/activity")
public class NearbyActivityController {
	
	@Autowired
	private ActivityService activityService;

	/**
	 * app 附近tab,搜索做
	 */
	@RequestMapping(value="NearbyTabs",method = RequestMethod.GET,params={"pageNum","pageSize"})
	public Object getNearbyActivityTab(HttpServletRequest request,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
		ResultModel resultModel = new ResultModel();
		if(pageNum <= 0){
			pageNum = 1;
		}
		if(pageSize <= 0 || pageSize > Constants.MAX_PAGESIZE){
			pageSize = Constants.PAGESIZE;
		}
		//经纬度
		Double longtitude,latitude;
		if(request.getParameter("longtitude") !=null && request.getParameter("latitude") != null){
			longtitude = Double.valueOf(request.getParameter("longtitude"));
			latitude = Double.valueOf(request.getParameter("latitude"));
			
			System.out.println("longtitude=" + longtitude + ";latitidu=" + latitude);
		}
		List<Activity> activitys = activityService.getActivitySortInCreateTime((pageNum-1)*pageSize, pageSize);
		ArrayList<ActivityModel> models = ActivityModel.ActListToActModelList(activitys);
		
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(models);
		
		return resultModel;
	}
	/*
	@RequestMapping(value = "nearby")
	public Object getNearByActivity(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get gold time success");
		
        ArrayList<ActivityModel> recomment_activity = new ArrayList<ActivityModel>();
		
		ArrayList<UserModel> relative_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			relative_user.add(new UserModel(100000000L, "/user/avatar/"+10*i+".jpg", "name"+i, (i%2==0)?"male":"female"));
		}
		
		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 1; i < 4; i++) {
			photos.add(new Photo("/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg"));
		}
		
		ArrayList<CategoryModel> interest_list = new ArrayList<CategoryModel>();
		for (int i = 0; i < 4; i++) {
			interest_list.add(new CategoryModel(10000000+i, "兴趣"+i, "/interest/cover/" + (20 + i) + ".jpg", "兴趣介绍"));
		}
		
		for (int i = 0; i < 10; i++) {
			recomment_activity.add(
					new ActivityModel("activity", (long)11110000+i, "活动名"+i*2, (float)(10.111+i),
					(i%2==0)?true:false, 100*i, (i%2!=0)?true:false, 200*i,300*i, "组织者 "+i+" 号", 
							addDate((i/2)*2), new Date(i*3), new Contact("1234567890"+i), "活动"+i+"摘要", "活动"+i+"url", photos,  
							new LocationInfo(100.12 + i * 2,120.89 + i * 3, "北京市海淀区西土城路"), 
					relative_user, interest_list)
					);
		}
		resultModel.setData(recomment_activity);
		return resultModel;
	}
	
	@RequestMapping(value = "rec_nearby", method = RequestMethod.GET)
	public Object getRecNearbyActivities() {
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
	
	public Date addDate(int day) {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, day);
		return new Date(c.getTimeInMillis());
	}
	*/
}
