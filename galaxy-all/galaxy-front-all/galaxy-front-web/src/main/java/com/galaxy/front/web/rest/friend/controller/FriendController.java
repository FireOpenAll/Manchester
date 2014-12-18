package com.galaxy.front.web.rest.friend.controller;

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
import com.galaxy.dal.domain.user.UserFriendApply;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.friend.ContactsItemModel;
import com.galaxy.front.web.rest.model.friend.FriendApplyItemModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.card.CardService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserFriendService;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

/*author:huangshanqi
 *time  :2014年12月14日 上午9:53:41
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/friend")
public class FriendController {

	@Autowired
	private UserFriendService userFriendService;
	@Autowired
	private UserService userService;
	@Autowired
	private CardService cardService;

	@RequestMapping(value = "apply", method = RequestMethod.POST, params = { "targetId", "message" })
	public Object addFriend(@RequestParam("targetId") Long targetId, @RequestParam("message") String message) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		UserFriendApply userFriendApply = new UserFriendApply();
		userFriendApply.setCreatedTime(new Date());
		userFriendApply.setUpdatedTime(userFriendApply.getCreatedTime());
		userFriendApply.setUserId(loginUser.getUserId());
		userFriendApply.setTargetId(targetId);
		userFriendApply.setMessage(message);
		userFriendApply.setApplyStatus(0);

		if (userFriendService.createUserFriendApply(userFriendApply)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("friend apply fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "deleteFriend", method = RequestMethod.POST, params = { "targetId" })
	public Object deleteFriend(@RequestParam("targetId") Long targetId) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		if (userFriendService.deleteUserFriendByUseridTargetid(loginUser.getUserId(), targetId)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("delete ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("delete friend fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "accept", method = RequestMethod.POST, params = { "targetId" })
	public Object acceptFriend(@RequestParam("targetId") Long targetId) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();
		UserFriend userFriend = new UserFriend();
		userFriend.setCreatedTime(new Date());
		userFriend.setUpdatedTime(userFriend.getCreatedTime());
		userFriend.setUserId(loginUser.getUserId());
		userFriend.setTargetId(targetId);

		// 校验信息

		if (userFriendService.acceptFriendApply(userFriend)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("accept ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("accept friend fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "allFriendApply", method = RequestMethod.GET)
	public Object getAllFriendApply() {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		List<UserFriendApply> applys = userFriendService.getAllUserFriendApply(loginUser.getUserId());

		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		if (applys != null) {
			ArrayList<FriendApplyItemModel> results = new ArrayList<FriendApplyItemModel>();
			User user = null;
			for (UserFriendApply apply : applys) {
				user = userService.getUserById(apply.getUserId());

				FriendApplyItemModel item = new FriendApplyItemModel();
				item.setTargetId(user.getId());
				item.setAvatar(user.getAvatar());
				item.setNickName(user.getNick());
				item.setApplyMessage(apply.getMessage());
                item.setAddFriend(apply.getApplyStatus()==1);
				results.add(item);
			}

			resultModel.setData(results);
		}
		return resultModel;
	}

	@RequestMapping(value = "getAllFriend", method = RequestMethod.GET)
	public Object getAllFriend() {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		List<User> list = userFriendService.getAllUserFriend(loginUser.getUserId());

		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		resultModel.setData(ContactsItemModel.userListToContactsList(list));
		
		return resultModel;
	}

}
