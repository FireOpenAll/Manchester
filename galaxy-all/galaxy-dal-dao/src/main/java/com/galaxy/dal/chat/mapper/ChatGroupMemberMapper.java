package com.galaxy.dal.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.chat.ChatGroupMember;

public interface ChatGroupMemberMapper  extends BaseMapper<ChatGroupMember>{
	boolean removeMember(@Param("groupId")Long groupId,@Param("userId")Long userId);
	
	List<ChatGroupMember> getGroupMembers(Long groupId);
	
	ChatGroupMember getMemberByUserId(Long groupId,Long userId);
	
	boolean grantGroupManager(Long groupId, Long ownerId, Long userId);

}
