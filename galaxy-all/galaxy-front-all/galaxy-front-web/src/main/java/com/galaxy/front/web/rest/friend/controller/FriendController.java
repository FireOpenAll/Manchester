package com.galaxy.front.web.rest.friend.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.UserFriendApply;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserFriendService;
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
	
	@RequestMapping(value="",method=RequestMethod.POST,params={"targetId","message"})
	public Object addFriend(@RequestParam("targetId") Long targetId,@RequestParam("message") String message){
		ResultModel resultModel = new ResultModel();
		
		LoginUserModel  loginUser = UserUtils.getLoginUser();
		
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
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("add friend fail"));
		}
		
		return resultModel;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST,params={"targetId"})
	public Object deleteFriend(@RequestParam("targetId") Long targetId){
		ResultModel resultModel = new ResultModel();
		
		LoginUserModel  loginUser = UserUtils.getLoginUser();
		

		if (userFriendService.deleteUserFriendByUseridTargetid(loginUser.getUserId(),targetId)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("delete ok"));
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("delete friend fail"));
		}
	   
		
		return resultModel;
	}
	
//	@RequestMapping(value="accept",method=RequestMethod.POST,params={"applyId"})
//	public Object acceptFriend(@RequestParam("applyId") Long applyId){
//		ResultModel resultModel = new ResultModel();
//		
//		LoginUserModel  loginUser = UserUtils.getLoginUser();
//		UserFriendApply apply = userFriendService.get
//      
//		if (userFriendService.deleteUserFriendByUseridTargetid(loginUser.getUserId(),targetId)) {
//			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
//			resultModel.setData(new StatusModel("delete ok"));
//		}else{
//			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
//			resultModel.setData(new StatusModel("delete friend fail"));
//		}
//	   
//		
//		return resultModel;
//	}
	
	
}
