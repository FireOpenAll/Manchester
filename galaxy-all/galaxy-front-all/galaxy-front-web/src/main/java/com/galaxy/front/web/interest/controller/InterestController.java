package com.galaxy.front.web.interest.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.interest.InterestDetailModel;
import com.galaxy.front.web.rest.model.interest.InterestGroup;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年9月20日 下午3:59:54
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "api/v1/interest")
public class InterestController {

	/**
	 * 获取兴趣的分类
	 * 用于注册时的list
	 * @return
	 */
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Object getTopInterests() {
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get interest category list success");

		List<InterestModel> interestModels = new ArrayList<InterestModel>();
		for (int i = 0; i < 12; i++) {
			interestModels.add(new InterestModel(10000000 + i, "推荐兴趣" + i, "/interest/cover/" + (10 + i) + ".jpg", i
					+ "热门兴趣描述"));
		}
		InterestGroup interestGroup = new InterestGroup(12, interestModels);

		resultModel.setData(interestGroup);
		return resultModel;
	}
	
	/**
	 * 获取兴趣的详细信息
	 * interest.jpg
	 * @param : interest_id
	 * @return : ResultModel
	 */
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public Object getInterertDetail(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get interest detail");
		
		InterestDetailModel interestDetailModel = new InterestDetailModel();
		
		interestDetailModel.setInterest_id(1010101010L);
		interestDetailModel.setInterest_name("测试兴趣");
		interestDetailModel.setCover(new Photo("/interest/cover/10.jpg", "/interest/cover/10.jpg", "/interest/cover/10.jpg"));
		interestDetailModel.setDescription("这是一个兴趣详细view的返回测试测试");
		interestDetailModel.setActivity_count(666);
		interestDetailModel.setMember_count(777);
		
		ArrayList<UserModel> recomment_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			recomment_user.add(new UserModel(100000000L, "/user/avatar/"+10*i+".jpg", "name"+i, (i%2==0)?"male":"female"));
		}
		interestDetailModel.setRecomment_user(recomment_user);
		
		ArrayList<InterestModel> interestModels = new ArrayList<InterestModel>();
		for (int i = 0; i < 12; i++) {
			interestModels.add(new InterestModel(10000000 + i, "推荐兴趣" + i, "/interest/cover/" + (10 + i) + ".jpg", i
					+ "热门兴趣描述"));
		}
		interestDetailModel.setRelative_interest(interestModels);
		
		
		resultModel.setData(interestDetailModel);
		
		return resultModel;
	}

	
	
}
