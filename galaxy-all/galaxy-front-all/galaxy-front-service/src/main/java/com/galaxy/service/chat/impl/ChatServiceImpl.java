package com.galaxy.service.chat.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.galaxy.dal.chat.mapper.ChatGroupApplyMapper;
import com.galaxy.dal.chat.mapper.ChatGroupInviteMapper;
import com.galaxy.dal.chat.mapper.ChatGroupMapper;
import com.galaxy.dal.chat.mapper.ChatGroupMemberMapper;
import com.galaxy.dal.domain.DBStatus;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.dal.domain.chat.ChatGroup;
import com.galaxy.dal.domain.chat.ChatGroupApply;
import com.galaxy.dal.domain.chat.ChatGroupInvite;
import com.galaxy.dal.domain.chat.ChatGroupMember;
import com.galaxy.dal.domain.chat.ChatGroupRole;
import com.galaxy.dal.domain.user.User;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.chat.ChatException;
import com.galaxy.service.chat.ChatExceptionCode;
import com.galaxy.service.chat.ChatService;
import com.galaxy.service.user.UserService;
@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatGroupMapper chatGroupMapper;
	@Autowired
	ChatGroupMemberMapper chatGroupMemberMapper;
	@Autowired
	ChatGroupInviteMapper chatGroupInviteMapper;
	@Autowired
	ChatGroupApplyMapper chatGroupApplyMapper;
	@Autowired
	ActivityService activityService;
	
	@Autowired
	UserService userService;
	

	@Override
	public Long createGroup(String groupName, Long ownerId,Long activityId) {
		Assert.notNull(ownerId, "group owner id is not null!");
		ChatGroup group=new ChatGroup();
		group.setName(groupName);
		group.setOwnerUserId(ownerId);
		group.setActivityId(activityId);
		group.setCreatedTime(new Date()); 
		chatGroupMapper.insert(group);
		return group.getId();
	}

	@Override
	public Long joinGroup(Long activityId, Long userId) {
		ChatGroup chatGroup=getGroupByActivityId(activityId); 
		
		User user=userService.getUser(userId); 
		if(user==null){
			throw new ChatException(ChatExceptionCode.USER_NOT_EXIST,"could not find user for id="+userId);
		} 
		ActivityJoinedUsers activityJoinUser=activityService.getActivityJoinUserByUserId(activityId,userId);
		if(activityJoinUser==null){
			throw new ChatException(ChatExceptionCode.NOT_MEMBER_OF_ACTIVIT,"not member of activity, id="+activityId+" user id="+userId);
		}
		
		ChatGroupMember member=new ChatGroupMember();
		member.setCreatedTime(new Date());
		member.setEmail(user.getEmail());
		member.setGroupId(chatGroup.getId());
		member.setPhone(user.getMobile());
		member.setRole(ChatGroupRole.MEMBER);
		member.setStatus(DBStatus.INIT);
		member.setUserId(userId);
		member.setUserName(user.getLoginName());
		chatGroupMemberMapper.insert(member);
		
		//TODO notify member join
		return member.getId();
	}
 
	public ChatGroup getGroupByActivityId(Long activityId) { 
		ChatGroup chatGroup= chatGroupMapper.getGroupByActivityId(activityId);
		if(chatGroup==null){
			throw new ChatException(ChatExceptionCode.GROUP_NOT_EXIST,"could not find group for activity id="+activityId);
		} 
		return chatGroup;
	}
	@Override
	public ChatGroup getGroupById(Long groupId) { 
		ChatGroup chatGroup= chatGroupMapper.getById(groupId);
		if(chatGroup==null){
			throw new ChatException(ChatExceptionCode.GROUP_NOT_EXIST,"could not find group for id="+groupId);
		} 
		return chatGroup;
	}
	@Override
	public boolean quitGroup(Long groupId,Long userId) {
		chatGroupMemberMapper.removeMember(groupId, userId);
		return true;
	}
	@Override
	public boolean applyToGroup(Long groupId, Long userId, String applyReason) {
		ChatGroup group=getGroupById(groupId); 
		if(group.getActivityId()!=null&&group.getActivityId()>0){
			ActivityJoinedUsers activityJoinUser=activityService.getActivityJoinUserByUserId(group.getActivityId(),userId);
			if(activityJoinUser==null){
				throw new ChatException(ChatExceptionCode.NOT_MEMBER_OF_ACTIVIT,"not member of activity, id="+group.getActivityId()+" user id="+userId);
			}
			
		}
		User user=userService.getUser(userId); 
		if(user==null){
			throw new ChatException(ChatExceptionCode.USER_NOT_EXIST,"could not find user for id="+userId);
		} 
		ChatGroupApply apply=new ChatGroupApply();
		apply.setApplyReason(applyReason);
		apply.setCreatedTime(new Date());
		apply.setUserId(userId);
		apply.setStatus(ChatGroupApply.Status.INIT);
		apply.setGroupId(group.getId()); 
		chatGroupApplyMapper.insert(apply);
		//TODO Notification
		return true;
	}
	@Override
	public boolean inviteToGroup(Long groupId, Long fromUserId, Long toUserId) {
		ChatGroup group=getGroupById(groupId); 
		User user=userService.getUser(toUserId); 
		if(user==null){
			throw new ChatException(ChatExceptionCode.USER_NOT_EXIST,"could not find user for id="+toUserId);
		} 
		
		user=userService.getUser(fromUserId); 
		if(user==null){
			throw new ChatException(ChatExceptionCode.USER_NOT_EXIST,"could not find user for id="+fromUserId);
		} 
		ChatGroupInvite inviteEntity=new ChatGroupInvite();
		inviteEntity.setGroupId(group.getId());
		inviteEntity.setFromId(fromUserId);
		inviteEntity.setUserId(toUserId);
		inviteEntity.setStatus(ChatGroupInvite.Status.INIT);
		inviteEntity.setCreatedTime(new Date());
		chatGroupInviteMapper.insert(inviteEntity);
		return true;
	}

	@Override
	public boolean grantGroupManager(Long groupId, Long ownerId, Long userId) {
		ChatGroup chatGroup=getGroupById(groupId); 
		if(chatGroup.getOwnerUserId()!=ownerId){
			throw new ChatException(ChatExceptionCode.NO_RIGHT_OPERATE,"you have no right to operate, group="+groupId+",member id="+userId);
		}
		ChatGroupMember member=getMemberByUserId(groupId,userId);
		
		boolean result=chatGroupMemberMapper.grantGroupManager(groupId,  member.getUserId());
		return result;
	}
	/**
	 * 独立方法方便做缓存
	 * @param groupId
	 * @param userId
	 * @return
	 */
	ChatGroupMember getMemberByUserId(Long groupId,Long userId){
		ChatGroupMember member=chatGroupMemberMapper.getMemberByUserId(groupId, userId); 
		if(member==null){
			throw new ChatException(ChatExceptionCode.MEMBER_NOT_FOUND,"can not find member for group="+groupId+",member id="+userId);
		}
		return member;
	}
	@Override
	public boolean removeMember(Long groupId, Long userId, Long mangerUserId) {
		ChatGroupMember member=getMemberByUserId(groupId, mangerUserId); 
		if(member.getRole()!=null&&!member.getRole().isManager()){//check user wether has manager role to remove
			throw new ChatException(ChatExceptionCode.NO_RIGHT_OPERATE,"you have no right to operate,group id="+groupId+" user id="+userId);
		}
		//TODO notify member remove
		chatGroupMemberMapper.removeMember(groupId, userId);
		return true;
	}

	@Override
	public List<ChatGroupMember> getGroupMembers(Long groupId) {
		ChatGroup chatGroup=getGroupById(groupId);
		if(chatGroup==null){
			throw new ChatException(ChatExceptionCode.NO_RIGHT_OPERATE,"could not find group for id="+groupId);
		} 
		return chatGroupMemberMapper.getGroupMembers(groupId);
	}

	@Override
	public boolean modifyGroupName(Long groupId,String name) { 
		return chatGroupMapper.updateGroupName(groupId, name);
	}

	

	

}
