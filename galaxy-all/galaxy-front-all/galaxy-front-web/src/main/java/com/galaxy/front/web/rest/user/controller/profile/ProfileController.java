package com.galaxy.front.web.rest.user.controller.profile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.form.UserProfileForm;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.location.SimpleAddress;
import com.galaxy.front.web.rest.model.profile.CreditInfo;
import com.galaxy.front.web.rest.model.profile.OthersProfileModel;
import com.galaxy.front.web.rest.model.profile.OwnProfileModel;
import com.galaxy.front.web.utils.Code;
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

	@RequestMapping(value = "/user/profile/changeAvatar", method = RequestMethod.POST, params = { "avatar" })
	public Object changeAvatar(@RequestParam("avatar") String avatar) {
		ResultModel resultModel = new ResultModel();

		// Base64.decodeBase64(base64String)
		try {
			// Base64解码
			byte[] bytes = Base64.decodeBase64(avatar);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			String avatarFilePath = PathUtils.AVATAR_PATH + UserUtils.getLoginUser().getUserId() + "/";
			File imgFilePath = FileUtils.getFile(avatarFilePath, "testtest.jpg");
			// 生成图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("ok"));
			return resultModel;
		} catch (Exception e) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			return resultModel;
		}

		/*
		 * if(avatar != null){
		 * System.out.println("1111111111111111111111!!!!!!"+
		 * avatar.getOriginalFilename()); }else{
		 * System.out.println("file ====================================null");
		 * }
		 * 
		 * SimpleDateFormat simpleDateFormat = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); LoginUserModel loginUser =
		 * UserUtils.getLoginUser(); String avatarFilePath =
		 * PathUtils.AVATAR_PATH + loginUser.getUserId() + "/"; String
		 * avatarFileName = simpleDateFormat.format(new
		 * Date())+avatar.getOriginalFilename
		 * ().substring(avatar.getOriginalFilename().indexOf(".")); File
		 * targetFile1 = new File(avatarFilePath, avatarFileName); if
		 * (!targetFile1.exists()) { targetFile1.mkdirs(); } try {
		 * avatar.transferTo(targetFile1);
		 * 
		 * resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		 * resultModel.setData(new StatusModel("ok")); } catch
		 * (IllegalStateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

	}

	@RequestMapping(value = "/user/profile/updateForm", method = RequestMethod.POST)
	public Object updateProfileForm(@ModelAttribute UserProfileForm form) {
		ResultModel resultModel = new ResultModel();

		// System.out.println("11111111111111111111111111111111111"+ToStringBuilder.reflectionToString(form));

		form.setUserId(UserUtils.getLoginUser().getUserId());
		if (userService.updateProfileForm(form)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(form);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("update profile form fail"));
		}

		return resultModel;
	}
}
