package com.galaxy.dal.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.chat.ChatGroup;

public interface ChatGroupMapper  extends BaseMapper<ChatGroup>{
	boolean updateGroupName(@Param("groupId")Long groupId,@Param("name")String name);
	
	ChatGroup getGroupByActivityId(@Param("activityId")Long activityId);
	
	List<ChatGroup> getGroupsByManagerId(@Param("userId")Long userId);


}
