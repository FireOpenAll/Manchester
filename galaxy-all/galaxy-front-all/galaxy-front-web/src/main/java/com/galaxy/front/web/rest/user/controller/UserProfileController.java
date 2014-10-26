/**
 * 
 */
package com.galaxy.front.web.rest.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.interest.InterestGroup;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.SimpleAddress;
import com.galaxy.front.web.rest.model.profile.CreditInfo;
import com.galaxy.front.web.rest.model.profile.UserProfileModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.UserFriendService;
import com.galaxy.service.user.UserService;

/**
 * @author luolishu
 *
 */
@RestController
@RequestMapping(value = "api/v1/user")
public class UserProfileController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserFriendService userFriendService;
	

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Object modifyProfile() {
		/**
		 * 假数据
		 */
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("update user profile success");

		UserProfileModel profileModel = new UserProfileModel();

		profileModel.setUser_id(11110000);
		profileModel.setUser_name("paris");
		profileModel.setAvatar("/user/avatar/10.jpg");
		profileModel.setGender("male");
		profileModel.setBirthday(new Date());
		profileModel.setCredit_info(new CreditInfo(35, "活动达人"));
		profileModel.setLocation(new SimpleAddress("广东省", "广州市"));

		List<InterestModel> lisInterests = new ArrayList<InterestModel>();
		for (int i = 1; i < 6; i++) {
			lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i,"/interest/cover/"+(10+i)+".jpg",i+"热门兴趣描述"));
		}
		profileModel.setInterest_group(new InterestGroup(5, lisInterests));

		profileModel.setFollowing(500);
		profileModel.setFollowed(100);

		profileModel.setIs_followed(true);
		profileModel.setIs_following(false);

		profileModel.setJoined_count(100);
		profileModel.setLike_count(200);
		profileModel.setComment_count(300);
		profileModel.setCreate_count(400);

		resultModel.setData(profileModel);

		return resultModel;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET,params={"user_id","target_id"})
	public Object getProfile(@RequestParam("user_id") Long user_id,@RequestParam("target_id") Long target_id) {
		/**
		 * 假数据
		 */
		ResultModel resultModel = new ResultModel();

		resultModel.setCode("20000");
		resultModel.setMessage("update user profile success");

		UserProfileModel profileModel = new UserProfileModel();
		

		profileModel.setUser_id(target_id);
		profileModel.setUser_name("paris");
		profileModel.setAvatar("/user/avatar/10.jpg");
		profileModel.setGender("male");
		profileModel.setBirthday(new Date());
		profileModel.setCredit_info(new CreditInfo(35, "活动达人"));
		profileModel.setLocation(new SimpleAddress("广东省", "广州市"));

		List<InterestModel> lisInterests = new ArrayList<InterestModel>();
		for (int i = 1; i < 6; i++) {
			lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i,"/interest/cover/"+(10+i)+".jpg",i+"热门兴趣描述"));

		}
		profileModel.setInterest_group(new InterestGroup(5, lisInterests));

		profileModel.setFollowing(500);
		profileModel.setFollowed(100);

		profileModel.setIs_followed(true);
		profileModel.setIs_following(false);

		profileModel.setJoined_count(100);
		profileModel.setLike_count(200);
		profileModel.setComment_count(300);
		profileModel.setCreate_count(400);

		resultModel.setData(profileModel);

		return resultModel;
	}
	
	
	@RequestMapping(value = "/profile1", method = RequestMethod.GET,params={"user_id","target_id"})
	public Object getProfile1(@RequestParam("user_id") Long user_id,@RequestParam("target_id") Long target_id) {
		/**
		 * sql数据
		 */
		ResultModel resultModel = new ResultModel();

		if (ParamUtils.isNotEmpty(user_id,target_id)) {
			
			User user = userService.getUser(target_id);
			if (user != null) {
				UserProfileModel profileModel = new UserProfileModel();

				profileModel.setUser_id(user.getId());
				profileModel.setUser_name(user.getNick());//nickname
				profileModel.setAvatar(user.getAvatar());
				profileModel.setGender(user.getSex());
				profileModel.setBirthday(user.getBirthday());
				//待完善
				profileModel.setCredit_info(new CreditInfo(35, "活动达人"));
				profileModel.setLocation(new SimpleAddress("广东省", "广州市"));

				List<InterestModel> lisInterests = new ArrayList<InterestModel>();
				for (int i = 1; i < 6; i++) {
					lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i,"/interest/cover/"+(10+i)+".jpg",i+"热门兴趣描述"));

				}
				profileModel.setInterest_group(new InterestGroup(5, lisInterests));
				//待完善
				
				profileModel.setFollowed(user.getFollowers());
				profileModel.setFollowing(user.getFans());
				
				//得到用户参加过的活动数目
				int joined_count = activityService.getUserJoinedActNumber(target_id);
				profileModel.setJoined_count(joined_count);
				
				//得到用户点赞过的活动数目
				int liked_count = activityService.getLikedActNumByUserId(target_id);
				profileModel.setLike_count(liked_count);
				
				
				//得到用户评论过的活动数目
				int comment_count = activityService.getUserComActNum(target_id);
				profileModel.setComment_count(comment_count);
				
				//得到用户创建过的活动数
				int create_count = activityService.getUserCreatedActNum(user_id);
				profileModel.setCreate_count(create_count);			

				
				if (!user_id.equals(target_id)) {
					//查看他人的profile
					UserFriend userFriend = userFriendService.getUsersFriend(user_id, target_id);
					if (userFriend != null) {
						int relation = userFriend.getRelation();
						switch (relation) {
						case 1:
							profileModel.setIs_followed(false);
							profileModel.setIs_following(true);
							break;
						case 2:
							profileModel.setIs_followed(true);
							profileModel.setIs_following(false);
							break;
						case 3:
							profileModel.setIs_followed(true);
							profileModel.setIs_following(true);
						default:
							profileModel.setIs_followed(false);
							profileModel.setIs_following(false);
							break;
						}
					}else {
						profileModel.setIs_followed(false);
						profileModel.setIs_following(false);
					}
					
				}else {
					//查看自己的profile
					profileModel.setIs_followed(false);
					profileModel.setIs_following(false);
				}
				
				resultModel.setData(profileModel);
				
				
				
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_SELECT_NOT_EXISTS);
				resultModel.setData("用户不存在");
			}
			
			/*
			resultModel.setCode("20000");
			resultModel.setMessage("update user profile success");

			UserProfileModel profileModel = new UserProfileModel();

			profileModel.setUser_id(user_id);
			profileModel.setUser_name("paris");
			profileModel.setAvatar("/user/avatar/10.jpg");
			profileModel.setGender("male");
			profileModel.setBirthday(new Date());
			profileModel.setCredit_info(new CreditInfo(35, "活动达人"));
			profileModel.setLocation(new SimpleAddress("广东省", "广州市"));

			List<InterestModel> lisInterests = new ArrayList<InterestModel>();
			for (int i = 1; i < 6; i++) {
				lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i,"/interest/cover/"+(10+i)+".jpg",i+"热门兴趣描述"));

			}
			profileModel.setInterest_group(new InterestGroup(5, lisInterests));

			profileModel.setFollowing(500);
			profileModel.setFollowed(100);

			profileModel.setIs_followed(true);
			profileModel.setIs_following(false);

			profileModel.setJoined_count(100);
			profileModel.setLike_count(200);
			profileModel.setComment_count(300);
			profileModel.setCreate_count(400);

			resultModel.setData(profileModel);
			
			*/
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("请输入正确的参数");
		}
		return resultModel;
	}

}
