package com.galaxy.front.web.rest.chat;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.chat.ChatGroupMember;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.message.broker.MessageBroker;
import com.galaxy.service.chat.ChatService;
import com.galaxy.service.user.UserUtils;

@RestController(value = "GroupController")
@RequestMapping(value = "api/v1/chat/group")
public class GroupController {
	static Logger logger=LoggerFactory.getLogger(GroupController.class);
	@Autowired
	MessageBroker messageBroker;
	@Autowired
	ChatService chatService;
	
	/**
	 * 申请加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "join")
	public Object join(@RequestParam("activityId") Long activityId,@RequestParam(value="reason",required=false)String reason) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		
		Long memberId=chatService.joinGroup(activityId, UserUtils.getLoginUser().getUserId());
		if(memberId>0){
			result.setCode("40000");
			return result;
		}
		return result;
	}
 
	/**
	 * 申请加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "apply")
	public Object apply(@RequestParam("groupId") Long groupId,@RequestParam(value="reason",required=false)String reason) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		
	    boolean flag=chatService.applyToGroup(groupId, UserUtils.getLoginUser().getUserId(),reason);
		if(!flag){
			result.setCode("40000");
			return result;
		}
		return result;
	}
	/**
	 * 申请加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "invite")
	public Object invite(@RequestParam("groupId") Long groupId,Long userId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
	    boolean flag=chatService.inviteToGroup(groupId, UserUtils.getLoginUser().getUserId(), userId);
		if(!flag){
			result.setCode("40000");
			return result;
		}
		return result;
	}
	/**
	 * 加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "grant/manager")
	public Object grantManager(@RequestParam("groupId") Long groupId,@RequestParam("userId") Long userId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		if(groupId==null||userId ==null){
			logger.error("groupId or userId is null!");
			result.setCode("40000");
			return result;
		}
		boolean flag=chatService.grantGroupManager(groupId, UserUtils.getLoginUser().getUserId(), userId);
		if(!flag){
			result.setCode("40000");
		}
		return result;
	}
	/**
	 * 删除用户
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "remove")
	public Object remove(@RequestParam("groupId") Long groupId,@RequestParam("userId") Long userId) {
		ResultModel result = new ResultModel();
		if(groupId==null||userId ==null){
			logger.error("groupId or userId is null!");
			result.setCode("40000");
			return result;
		}
		result.setCode("20000");
		boolean flag=chatService.removeMember(groupId, userId, UserUtils.getLoginUser().getUserId());
		if(!flag){
			result.setCode("40000");
		}
		return result;
	}
 
	/**
	 * 创建群组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "create")
	public Object create(@RequestParam("groupName") String groupName) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		Long groupId=chatService.createGroup(groupName, UserUtils.getLoginUser().getUserId(), null);
		if(groupId==null){
			result.setCode("40000");
			logger.error("create group name="+groupName+" failure");
			return result;
		}
		return result;
	}
	/**
	 * 查询群组所有用户
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "member/all")
	public Object members(@RequestParam("groupId") Long groupId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		List<ChatGroupMember> groupMemberList=chatService.getGroupMembers(groupId);
		
		List<GroupMemberModel> resultModels=convertToModelList(groupMemberList);
		result.setData((Serializable) resultModels);
		return result;
	}
	
	/**
	 * 查询群组所有用户
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "modify/name")
	public Object modifyGroupName(@RequestParam("groupId") Long groupId,@RequestParam("name")String name) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		List<ChatGroupMember> groupMemberList=chatService.getGroupMembers(groupId);
		
		List<GroupMemberModel> resultModels=convertToModelList(groupMemberList);
		result.setData((Serializable) resultModels);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	private List<GroupMemberModel> convertToModelList(List<ChatGroupMember> groupMemberList){
		if(groupMemberList==null){
			return Collections.EMPTY_LIST;
		}
		List<GroupMemberModel> resultList=new LinkedList<GroupMemberModel>();
		for(ChatGroupMember item:groupMemberList){
			GroupMemberModel model=GroupMemberModel.convert(item);
			resultList.add(model);
		}
		return resultList;
	}
	 
	public static class GroupMemberModel implements Serializable{ 
		private static final long serialVersionUID = 7811144442222110210L;

		static GroupMemberModel convert(ChatGroupMember member){
			GroupMemberModel model=new GroupMemberModel();
			return model;
		}
	}
}
