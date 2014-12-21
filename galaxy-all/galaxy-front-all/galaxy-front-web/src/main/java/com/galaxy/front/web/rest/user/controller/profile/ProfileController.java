package com.galaxy.front.web.rest.user.controller.profile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.location.SimpleAddress;
import com.galaxy.front.web.rest.model.profile.CreditInfo;
import com.galaxy.front.web.rest.model.profile.OthersProfileModel;
import com.galaxy.front.web.rest.model.profile.OwnProfileModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.front.web.utils.PathUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.card.CardService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserFriendService;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

/*author:huangshanqi
 *time  :2014年12月13日 下午3:18:47
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1")
public class ProfileController {

	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserFriendService userFriendService;
	@Autowired
	private CardService cardService;

	// 自己的
	@RequestMapping(value = "/user/profile/get", method = RequestMethod.GET)
	public Object getOwnProfile(HttpServletRequest request) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		if (loginUser != null) {
			// 自己的
			User user = userService.getUserById(loginUser.getUserId());
			OwnProfileModel profile = new OwnProfileModel();
			profile.setUserId(user.getId());
			profile.setLoginName(user.getLoginName());
			profile.setNickName(user.getNick());
			//
			profile.setTags(Arrays.asList("IT;互联网;创业".split(";")));

			int publishActNum = activityService.getUserpublishedActNumber(user.getId());
			profile.setPublishActNum(publishActNum);

			int joinActNum = activityService.getUserJoinedActNumber(user.getId());
			profile.setJoinActNum(joinActNum);

			int collectActNum = activityService.getUserCollectActNum(user.getId());
			profile.setCollectActNum(collectActNum);

			int commentActNum = activityService.getUserComActNum(user.getId());
			profile.setCommentActNum(commentActNum);

			profile.setAvatar(user.getAvatar());
			profile.setGender(user.getGender().toString());
			profile.setBirthday(user.getBirthday());
			//
			profile.setCreditInfo(new CreditInfo(100, "高级活动达人"));
			//
			profile.setAddress(new SimpleAddress("北京", "北京市"));

			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(profile);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);

		}
		return resultModel;
	}

	// 他人的
	@RequestMapping(value = "/profile/get", method = RequestMethod.GET, params = { "targetId" })
	public Object getOtherProfile(@Param("targetId") Long targetId) {
		ResultModel resultModel = new ResultModel();

		// 他人的
		User other = userService.getUserById(targetId);

		OthersProfileModel profile = new OthersProfileModel();

		profile.setUserId(other.getId());
		profile.setLoginName(other.getLoginName());
		profile.setNickName(other.getNick());
		//
		profile.setTags(Arrays.asList("IT;互联网;创业".split(";")));

		int publishActNum = activityService.getUserpublishedActNumber(other.getId());
		profile.setPublishActNum(publishActNum);

		int joinActNum = activityService.getUserJoinedActNumber(other.getId());
		profile.setJoinActNum(joinActNum);

		int collectActNum = activityService.getUserCollectActNum(other.getId());
		profile.setCollectActNum(collectActNum);

		int commentActNum = activityService.getUserComActNum(other.getId());
		profile.setCommentActNum(commentActNum);

		profile.setAvatar(other.getAvatar());
		profile.setGender(other.getGender().toString());
		profile.setBirthday(other.getBirthday());
		//
		profile.setCreditInfo(new CreditInfo(100, "高级活动达人"));
		//
		profile.setAddress(new SimpleAddress("北京", "北京市"));

		if (UserUtils.isAppLogin()) {
			// 登录
			LoginUserModel loginUser = UserUtils.getLoginUser();
			profile.setAddCard(cardService.hasAddCard(loginUser.getUserId(), targetId));
			profile.setAddFriend(userFriendService.hasAddFriend(loginUser.getUserId(), targetId));
		} else {
			// 未登录
			profile.setAddCard(false);
			profile.setAddFriend(false);

		}
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(profile);

		return resultModel;
	}
	
	
	@RequestMapping(value = "/user/profile/changeAvatar",method = RequestMethod.POST)
	public Object changeAvatar(@RequestParam("avatar")MultipartFile avatar){
		ResultModel resultModel = new ResultModel();
		
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		LoginUserModel loginUser = UserUtils.getLoginUser();
		String avatarFilePath = PathUtils.AVATAR_PATH + loginUser.getUserId() + "/";
		String avatarFileName = simpleDateFormat.format(new Date())+avatar.getOriginalFilename().substring(avatar.getOriginalFilename().indexOf("."));
		File targetFile1 = new File(avatarFilePath, avatarFileName);
		if (!targetFile1.exists()) {
			targetFile1.mkdirs();
		}
		try {
			avatar.transferTo(targetFile1);
			
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("ok"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultModel;
	}
	
}
