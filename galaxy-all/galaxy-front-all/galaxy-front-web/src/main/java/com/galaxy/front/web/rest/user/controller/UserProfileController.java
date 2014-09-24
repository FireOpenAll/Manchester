/**
 * 
 */
package com.galaxy.front.web.rest.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.profile.CreditInfo;
import com.galaxy.front.web.rest.model.profile.InterestGroup;
import com.galaxy.front.web.rest.model.profile.InterestModel;
import com.galaxy.front.web.rest.model.profile.SimpleLocation;
import com.galaxy.front.web.rest.model.profile.UserProfileModel;

/**
 * @author luolishu
 *
 */
@RestController
@RequestMapping(value = "api/v1/user")
public class UserProfileController {

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Object modifyProfile() {
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
		profileModel.setLocation(new SimpleLocation("广东省", "广州市"));

		List<InterestModel> lisInterests = new ArrayList<InterestModel>();
		for (int i = 1; i < 6; i++) {
			lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i));

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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public Object getProfile() {
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
		profileModel.setLocation(new SimpleLocation("广东省", "广州市"));

		List<InterestModel> lisInterests = new ArrayList<InterestModel>();
		for (int i = 1; i < 6; i++) {
			lisInterests.add(new InterestModel((long) i * 10000000, "兴趣" + i));

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

}
