package com.galaxy.service.chat;

import java.util.List;

import com.galaxy.dal.domain.chat.ChatGroup;
import com.galaxy.dal.domain.chat.ChatGroupMember;

public interface ChatService {
	
	Long createGroup(String groupName,Long ownerId,Long activityId);
	
	ChatGroup getGroupById(Long groupId);
    /**
     * 
     * @param groupId
     * @param userId
     * @return
     */
	Long joinGroup(Long activityId, Long userId);

	boolean quitGroup(Long groupId,Long userId);
	
	boolean removeMember(Long groupId,Long userId,Long mangerUserId);

	boolean inviteToGroup(Long groupId, Long fromUserId, Long toUserId);
	
	boolean grantGroupManager(Long groupId,Long ownerId,Long userId);
	
	boolean applyToGroup(Long groupId,Long userId,String applyReason);
	
	List<ChatGroupMember> getGroupMembers(Long groupId);
	
	boolean modifyGroupName(Long groupId,String name);
	
	

}
