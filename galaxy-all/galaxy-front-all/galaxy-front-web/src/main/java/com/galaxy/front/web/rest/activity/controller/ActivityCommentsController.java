package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.CommentModel;
import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;

@RestController(value = "restActivityCommentsController")
@RequestMapping(value = "api/v1/activity")
public class ActivityCommentsController {

	/**
	 * @param : activity_id, until_id, count
	 * 
	 * @return ResultModel
	 */
	@RequestMapping(value = "comment", method = RequestMethod.GET)
	public Object getCommentByActId() {

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
	}

	/**
	 * @param :activity_id,user_id,content
	 * @return
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public Object postCommentByActId() {
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("post comment success");

		CommentModel commentModel=  new CommentModel(111100001, new UserModel(101010101, "/interest/cover/30.jpg", "name", "male"), "评论内容", new Date());
		

		resultModel.setData(commentModel);
		return resultModel;
	}
	
	/**
	 * 获取我评论过的活动列表，分页查询
	 * @param user_id
	 * @param until_id
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "getCommentedActivity",method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getLikedActivity(@RequestParam("user_id") long user_id,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
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
	}

}
