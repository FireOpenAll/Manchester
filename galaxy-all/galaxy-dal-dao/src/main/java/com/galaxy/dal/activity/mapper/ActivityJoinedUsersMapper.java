package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;

public interface ActivityJoinedUsersMapper extends
		BaseMapper<ActivityJoinedUsers> {
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId);

	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(@Param("activityId")Long activityId,@Param("fromId")Long fromId, @Param("size")int size);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(@Param("user_id")Long user_id);
	
	public List<ActivityJoinedUsers> listAllJoinedActs(@Param("user_id")Long userId);
	
	//
	public ActivityJoinedUsers getByUserIdActId(@Param("user_id") Long userId,@Param("activity_id") Long activityId);
}
