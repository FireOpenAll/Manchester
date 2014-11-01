package com.galaxy.front.web.rest.user.controller;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.front.web.rest.model.ListModel;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.user.FollowInfoModel;
import com.galaxy.front.web.rest.model.user.FollowshipUserModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.UserFriendService;
import com.galaxy.service.user.UserService;

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
	@Autowired
	private UserFriendService userFriendService;
	@Autowired
	private UserService userService;

	
	/*得到我关注的人*/
	@RequestMapping(value = "/following" ,method = RequestMethod.GET,params={"user_id","pageNum","pageSize"})
	public Object getFollowing(@RequestParam("user_id") Long user_id,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
		/*
		 * parameter:
		 * userid，untilid,count
		 */
		/*
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
		*/
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,pageNum,pageSize)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			
			List<UserFriend> relations = userFriendService.getFollowingsByOffset(user_id,pageNum,pageSize);
			if (relations == null) {
				return resultModel;
			}
			ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
			
			ArrayList<FollowshipUserModel> resultList = new ArrayList<FollowshipUserModel>();
			for(UserFriend userFriend:relations){
				Long target_id = (user_id == userFriend.getTargetId())?userFriend.getUserId():userFriend.getTargetId();
				User user = userService.getUser(target_id);//user==他人的信息
				if (user != null) {
					FollowshipUserModel followshipUserModel = new FollowshipUserModel();
					followshipUserModel.setUserid(user.getId());
					followshipUserModel.setName(user.getLoginName());
					followshipUserModel.setGender(user.getSex());
					followshipUserModel.setAvatar(user.getAvatar());
					
					switch (userFriend.getRelation()) {
					case 3:
						followshipUserModel.setFollowed(true);
						followshipUserModel.setFollowing(true);
						break;
					case 2:
						if (user.getId() == userFriend.getUserId()) {
							followshipUserModel.setFollowed(false);
							followshipUserModel.setFollowing(true);
						}else {
							followshipUserModel.setFollowed(true);
							followshipUserModel.setFollowing(false);
						}
						break;
					case 1:
						if (user.getId() == userFriend.getUserId()) {
							followshipUserModel.setFollowed(true);
							followshipUserModel.setFollowing(false);
						}else {
							followshipUserModel.setFollowed(false);
							followshipUserModel.setFollowing(true);
						}
						break;

					default:
						followshipUserModel.setFollowed(false);
						followshipUserModel.setFollowing(false);
						break;
					}
					
					resultList.add(followshipUserModel);
				}
			}
			listModel.setList(resultList);
			listModel.setCount(resultList.size());
			resultModel.setData(listModel);
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("get fans error");
		}
			
		return resultModel;
		
	}
	
	/*关注某人*/
	@RequestMapping(value = "/follow" ,method = RequestMethod.POST,params={"user_id","target_id"})
	public Object followSomeone(@RequestParam("user_id") Long user_id,@RequestParam("target_id") Long target_id){
		/*
		 * parameter:
		 * userid，targetid
		 */
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("follow someone success");
		
		StatusModel statusModel = new StatusModel();
		statusModel.setStatus("ok");
		
		resultModel.setData(statusModel);
		*/
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(user_id,target_id)) {
			UserFriend userFriend = userFriendService.getUsersFriend(user_id, target_id);
			if (userFriend == null) {
				UserFriend newUserFriend = new UserFriend();
				newUserFriend.setUserId(user_id);
				newUserFriend.setTargetId(target_id);
				newUserFriend.setCreatedTime(new Date());
				newUserFriend.setRelation(1);
			    if (userFriendService.insert(newUserFriend)) {
			    	User user = userService.getUser(user_id);
					User targetUser = userService.getUser(target_id);
					userService.updateUserFollowersNumById(user.getId(),user.getFollowers()+1);
					userService.updateUserFansNumById(targetUser.getId(),targetUser.getFans()+1);
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData(new StatusModel("ok"));		
					return resultModel;
			    }else {
			    	resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_ADD_ERROR);
					resultModel.setData(new StatusModel("follow error"));
					return resultModel;
				}
			}else {
				switch (userFriend.getRelation()) {
				case 2:
					if(user_id == userFriend.getUserId()){
						userFriend.setRelation(3);
						if (userFriendService.update(userFriend)) {
							//success
							User user = userService.getUser(user_id);
							User targetUser = userService.getUser(target_id);
							userService.updateUserFollowersNumById(user.getId(), user.getFollowers()+1);
							userService.updateUserFansNumById(targetUser.getId(), targetUser.getFans()+1);
						}else {
							//failed
							resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
							resultModel.setData(new StatusModel("follow error"));
						}
					}else {
						//已经关注
						resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
						resultModel.setData(new StatusModel("ok"));
					}
					break;
				case 1:
					if (user_id == userFriend.getTargetId()) {
						userFriend.setRelation(3);
						if (userFriendService.update(userFriend)) {
							//success
							User user = userService.getUser(user_id);
							User targetUser = userService.getUser(target_id);
							userService.updateUserFollowersNumById(user.getId(), user.getFollowers()+1);
							userService.updateUserFansNumById(targetUser.getId(), targetUser.getFans()+1);
							resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
							resultModel.setData(new StatusModel("ok"));
						}else {
							//failed
							resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
							resultModel.setData(new StatusModel("follow error"));
						}
					}else {
						//已经关注
						resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
						resultModel.setData(new StatusModel("already follow"));
					}
					break;

				case 0:
					if (user_id == userFriend.getUserId()) {
						userFriend.setRelation(1);
					}else {
						userFriend.setRelation(2);
					}
					if (userFriendService.update(userFriend)) {
						User user = userService.getUser(user_id);
						User targetUser = userService.getUser(target_id);
						userService.updateUserFollowersNumById(user.getId(), user.getFollowers()+1);
						userService.updateUserFansNumById(targetUser.getId(), targetUser.getFans()+1);
						resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
						resultModel.setData(new StatusModel("ok"));
					}else {
						resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
						resultModel.setData(new StatusModel("follow error"));
					}
					break;
				default:
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData(new StatusModel("ok"));
					break;
				}
				return resultModel;
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("follow error");
			return resultModel;
		}
	}
	
	/*取消关注*/
	@RequestMapping(value = "/unfollow" ,method = RequestMethod.POST,params = {"user_id","target_id"})
	public Object unfollowSomeone(@RequestParam("user_id") Long user_id,@RequestParam("target_id") Long target_id){
		/*
		 * parameter:
		 * userid，targetid
		 */
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("unfollow someone success");
		
		StatusModel statusModel = new StatusModel();
		statusModel.setStatus("ok");
		
		resultModel.setData(statusModel);
		*/
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(user_id,target_id)) {
			UserFriend userFriend = userFriendService.getUsersFriend(user_id, target_id);
			if (userFriend == null) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_SELECT_NOT_EXISTS);
				return resultModel;
			}else {
				switch (userFriend.getRelation()) {
				case 3:
					if (user_id == userFriend.getUserId()) {
						userFriend.setRelation(2);
					}else {
						userFriend.setRelation(1);
					}
					if (userFriendService.update(userFriend)) {
						User user = userService.getUser(user_id);
						User targetUser = userService.getUser(target_id);
						userService.updateUserFollowersNumById(user.getId(), (user.getFollowers()>0)?(user.getFollowers()-1):0);
						userService.updateUserFansNumById(targetUser.getId(), (targetUser.getFans()>0)?(targetUser.getFans()-1):0);
						resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
						resultModel.setData(new StatusModel("ok"));
					}else {
						resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
						resultModel.setData(new StatusModel("unfollow error"));
					}
					break;
				case 1:
					if (user_id == userFriend.getUserId()) {
						userFriend.setRelation(0);
						if (userFriendService.update(userFriend)) {
							User user = userService.getUser(user_id);
							User targetUser = userService.getUser(target_id);
							userService.updateUserFollowersNumById(user.getId(), (user.getFollowers()>0)?(user.getFollowers()-1):0);
							userService.updateUserFansNumById(targetUser.getId(), (targetUser.getFans()>0)?(targetUser.getFans()-1):0);
							resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
							resultModel.setData(new StatusModel("ok"));
						}else {
							//失败
							resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
							resultModel.setData(new StatusModel("unfollow error"));
						}
					}else {
						//还没有关注他
						resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
						resultModel.setData(new StatusModel("you have not follow him"));
					}
					break;
				case 2:
					if (user_id == userFriend.getUserId()) {
						//还没有关注他
						resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
						resultModel.setData(new StatusModel("you have not follow him"));
					}else {
						userFriend.setRelation(0);
						if (userFriendService.update(userFriend)) {
							User user = userService.getUser(user_id);
							User targetUser = userService.getUser(target_id);
							userService.updateUserFollowersNumById(user.getId(), (user.getFollowers()>0)?(user.getFollowers()-1):0);
							userService.updateUserFansNumById(targetUser.getId(), (targetUser.getFans()>0)?(targetUser.getFans()-1):0);
							resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
							resultModel.setData(new StatusModel("ok"));
						}else {
							//失败
							resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
							resultModel.setData(new StatusModel("unfollow error"));
						}
					}
					break;
				default:
					resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
					resultModel.setData("unfollow error");
					break;
				}
				return resultModel;
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("unfollow error");
			return resultModel;
		}	
	}
	
	/*得到我的朋友*/
	/*
	@RequestMapping(value = "/getFriends" ,method = RequestMethod.GET,params = {"user_id","until_id","pageSize"})
	public Object getFriends(@RequestParam("user_id") long user_id ,@RequestParam("until_id") long until_id,@RequestParam("pageSize") int pageSize){
	*/
	@RequestMapping(value = "/getFriends" ,method = RequestMethod.GET,params = {"user_id","pageNum","pageSize"})
	public Object getFriends(@RequestParam("user_id") long user_id ,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
	    /*
		 * parameter:
		 * user_id,pageSize,until_id
		 */
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get friends success");
		
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
		
		*/
		
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,pageNum,pageSize)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			
			List<UserFriend> relations = userFriendService.getMutualUsersByOffset(user_id,pageNum,pageSize);
			if (relations == null) {
				return resultModel;
			}
			ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
			
			ArrayList<FollowshipUserModel> resultList = new ArrayList<FollowshipUserModel>();
			for(UserFriend userFriend:relations){
				Long target_id = (user_id == userFriend.getTargetId())?userFriend.getUserId():userFriend.getTargetId();
				User user = userService.getUser(target_id);
				if (user != null) {
					FollowshipUserModel followshipUserModel = new FollowshipUserModel();
					followshipUserModel.setUserid(user.getId());
					followshipUserModel.setName(user.getLoginName());
					followshipUserModel.setGender(user.getSex());
					followshipUserModel.setAvatar(user.getAvatar());
					followshipUserModel.setFollowed(true);
					followshipUserModel.setFollowing(true);
					
					resultList.add(followshipUserModel);
				}
			}
			listModel.setList(resultList);
			listModel.setCount(resultList.size());
			resultModel.setData(listModel);
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("get fans error");
		}

		return resultModel;
	}
	
	/*检查两用户的关系*/
	@RequestMapping(value = "/checkRelationship " ,method = RequestMethod.GET,params = {"user_id","target_id"})
	public Object getFriends(@RequestParam("user_id") long user_id ,@RequestParam("target_id") long target_id){
		/*
		 * parameter:
		 * user_id,target_id
		 * return : FollowInfoModel
		 */
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("checkRelationship success");
		
		FollowInfoModel followInfoModel = new FollowInfoModel();
		followInfoModel.setUser_id(user_id);
		followInfoModel.setTarget_id(target_id);
		followInfoModel.setFollow(false);
		followInfoModel.setFollowed(true);
		
		resultModel.setData(followInfoModel);
		return resultModel;
		*/
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,target_id)) {
			resultModel=ResultModelUtils.getResultModelByCode(Code.OK);
			
			UserFriend userFriend= userFriendService.getUsersFriend(user_id, target_id);
			FollowInfoModel followInfoModel = new FollowInfoModel();
			followInfoModel.setUser_id(user_id);
			followInfoModel.setTarget_id(target_id);
			
			if (userFriend == null) {
				followInfoModel.setFollow(false);
				followInfoModel.setFollowed(false);
			}else {
				switch (userFriend.getRelation()) {
				case 3:
					followInfoModel.setFollow(true);
					followInfoModel.setFollowed(true);
					break;
				case 2:
					if (userFriend.getUserId() == user_id) {
						followInfoModel.setFollow(false);
						followInfoModel.setFollowed(true);
					}else {
						followInfoModel.setFollow(true);
						followInfoModel.setFollowed(false);
					}
					break;
				case 1:
					if (userFriend.getUserId() == user_id) {
						followInfoModel.setFollow(true);
						followInfoModel.setFollowed(false);
					}else {
						followInfoModel.setFollow(false);
						followInfoModel.setFollowed(true);
					}
					break;
				default:
					followInfoModel.setFollow(false);
					followInfoModel.setFollowed(false);
					break;
				}
			}
			resultModel.setData(followInfoModel);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		return resultModel;
	}
	
	
	
	/*得到我的粉丝*/
	@RequestMapping(value = "/followed" ,method = RequestMethod.GET,params = {"user_id","pageNum","pageSize"})
	public Object getFollowed(@RequestParam("user_id") Long user_id,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
		/*
		 * sql
		 */
		/*
		 * parameter:
		 * user_id，pageNum,pageSize
		 */
		/*
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get followed success");
		
		ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
		listModel.setCount(5);
		
		List<FollowshipUserModel> list = new ArrayList<FollowshipUserModel>();
		for (int i = 1; i < 6; i++) {
			list.add(new FollowshipUserModel(1000000+i, "/user/avatar/"+10*i+".jpg", i+"name", (i%2 == 0)?"male":"female",(i%2 == 0), (i%2 != 0)));
		}
		list.get(2).setFollowed(true);
		list.get(2).setFollowing(true);
		
		list.get(4).setFollowed(true);
		list.get(4).setFollowing(true);
		listModel.setList(list);
		
		resultModel.setData(listModel);
		return resultModel;
		 */
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,pageNum,pageSize)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			
			List<UserFriend> relations = userFriendService.getFollowedsByOffset(user_id,pageNum,pageSize);
			if (relations == null) {
				return resultModel;
			}
			ListModel<FollowshipUserModel> listModel = new ListModel<FollowshipUserModel>();
			
			ArrayList<FollowshipUserModel> resultList = new ArrayList<FollowshipUserModel>();
			for(UserFriend userFriend:relations){
				Long target_id = (user_id == userFriend.getTargetId())?userFriend.getUserId():userFriend.getTargetId();
				User user = userService.getUser(target_id);
				if (user != null) {
					FollowshipUserModel followshipUserModel = new FollowshipUserModel();
					followshipUserModel.setUserid(user.getId());
					followshipUserModel.setName(user.getLoginName());
					followshipUserModel.setGender(user.getSex());
					followshipUserModel.setAvatar(user.getAvatar());
					
					switch (userFriend.getRelation()) {
					case 3:
						followshipUserModel.setFollowed(true);
						followshipUserModel.setFollowing(true);
						break;
					case 2:
						if (user.getId() == userFriend.getUserId()) {
							followshipUserModel.setFollowed(false);
							followshipUserModel.setFollowing(true);
						}else {
							followshipUserModel.setFollowed(true);
							followshipUserModel.setFollowing(false);
						}
						break;
					case 1:
						if (user.getId() == userFriend.getUserId()) {
							followshipUserModel.setFollowed(true);
							followshipUserModel.setFollowing(false);
						}else {
							followshipUserModel.setFollowed(false);
							followshipUserModel.setFollowing(true);
						}
						break;

					default:
						followshipUserModel.setFollowed(false);
						followshipUserModel.setFollowing(false);
						break;
					}
					
					resultList.add(followshipUserModel);
				}
			}
			listModel.setList(resultList);
			listModel.setCount(resultList.size());
			resultModel.setData(listModel);
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("get fans error");
		}
			
		return resultModel;
	}
	
}
