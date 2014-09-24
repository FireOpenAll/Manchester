package com.galaxy.front.web.rest.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ListModel;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.user.FollowshipUserModel;
import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年9月21日 下午5:21:14
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "/api/v1/user")
public class FriendsController {
	/*
	 * 粉丝相关控制器
	 */

	@RequestMapping(value = "/followed" ,method = RequestMethod.GET)
	public Object getFollowed(){
		/*
		 * parameter:
		 * userid，untilid,count
		 */
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get followed success");
		
		ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
		listModel.setCount(5);
		
		List<FollowshipUserModel> list = new ArrayList<FollowshipUserModel>();
		for (int i = 1; i < 6; i++) {
			list.add(new FollowshipUserModel(1000000+i, "/user/avatar/"+10*i+".jpg", i+"name", (i%2 == 0)?"male":"female",(i%2 == 0), (i%2 != 0)));
			//new FollowshipUserModel(1000000+i, "/user/avatar/"+10*i+".jpg", i+"name", (i%2 == 0)?"male":"female", (i%2 == 0)?true:false, (i%2 == 0)?true:false)
			//list.add(new UserModel(1000000+i, "/user/avatar/"+10*i+".jpg", i+"name", (i%2 == 0)?"male":"female"));
		}
		list.get(2).setFollowed(true);
		list.get(2).setFollowing(true);
		
		list.get(4).setFollowed(true);
		list.get(4).setFollowing(true);
		listModel.setList(list);
		
		resultModel.setData(listModel);
		
		
		return resultModel;
	}
	
	
	@RequestMapping(value = "/following" ,method = RequestMethod.GET)
	public Object getFollowing(){
		/*
		 * parameter:
		 * userid，untilid,count
		 */
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get following success");
		
		ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
		listModel.setCount(5);
		
		List<FollowshipUserModel> list = new ArrayList<FollowshipUserModel>();
		for (int i = 1; i < 6; i++) {
			list.add(new FollowshipUserModel(1000000+i, "/user/avatar/"+10*i+".jpg", i+"name", (i%2 == 0)?"male":"female",(i%2 == 0), (i%2 != 0)));
		}
		list.get(1).setFollowed(true);
		list.get(1).setFollowing(true);
		
		list.get(3).setFollowed(true);
		list.get(3).setFollowing(true);
		listModel.setList(list);
		
		resultModel.setData(listModel);
		
		
		return resultModel;
	}
	
	
	@RequestMapping(value = "/follow" ,method = RequestMethod.POST)
	public Object followSomeone(){
		/*
		 * parameter:
		 * userid，targetid
		 */
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("follow someone success");
		
		StatusModel statusModel = new StatusModel();
		statusModel.setStatus("ok");
		
		resultModel.setData(statusModel);
		
		return resultModel;
	}
	
	
	@RequestMapping(value = "/unfollow" ,method = RequestMethod.POST)
	public Object unfollowSomeone(){
		/*
		 * parameter:
		 * userid，targetid
		 */
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("unfollow someone success");
		
		StatusModel statusModel = new StatusModel();
		statusModel.setStatus("ok");
		
		resultModel.setData(statusModel);
		
		return resultModel;
	}
	
	
}
