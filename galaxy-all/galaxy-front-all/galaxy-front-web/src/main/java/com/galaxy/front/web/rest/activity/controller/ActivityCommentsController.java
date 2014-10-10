package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.CommentModel;
import com.galaxy.front.web.rest.model.ResultModel;
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
	
	

}
