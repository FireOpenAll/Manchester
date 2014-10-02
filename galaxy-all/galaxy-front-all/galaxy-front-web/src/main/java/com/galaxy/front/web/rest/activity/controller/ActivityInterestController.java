package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年9月27日 下午12:59:09
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ActivityInterestController {
/**
 * 活动兴趣相关控制器
 */
	
	/**
	 * 圈子页面的活动api
	 * @param : interestId,count,until_id,
	 * @return 
	 */
	@RequestMapping (value = "/interest_activity",method = RequestMethod.GET)
	public Object getActivitysByInterestId(){
		ResultModel resultModel = new ResultModel();
		ArrayList<ActivityModel> recomment_activity = new ArrayList<ActivityModel>();
		
		ArrayList<UserModel> relative_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			relative_user.add(new UserModel(100000000L, "/user/avatar/"+10*i+".jpg", "name"+i, (i%2==0)?"male":"female"));
		}
		
		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 1; i < 4; i++) {
			photos.add(new Photo("/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg"));
		}
		
		for (int i = 0; i < 10; i++) {
			recomment_activity.add(new ActivityModel(1110001100L, 123456789L, "活动"+i, (float)(90.69+i), (i%2==0)?true:false, (++i%2==0)?true:false, i+"组织者", new Date(), new Date(), new Contact("12345678901"), "活动摘要"+i, "/activity/"+i, photos, new LocationInfo(100.12+i*2,120.89+i*3,"北京市海淀区西土城路"), relative_user));
		}
		
		resultModel.setCode("20000");
		resultModel.setMessage("get interest relate activity");
		resultModel.setData(recomment_activity);
		
		return resultModel;
	}
}
