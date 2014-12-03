package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityJoinedUser;

public interface ActivityJoinedUsersMapper extends
		BaseMapper<ActivityJoinedUser> {
	public List<ActivityJoinedUser> listAllJoinedUsers(Long activityId);

	public List<ActivityJoinedUser> listAllJoinedUsersFromId(@Param("activityId")Long activityId,@Param("fromId")Long fromId, @Param("size")int size);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(@Param("user_id")Long user_id);
	
	public List<ActivityJoinedUser> listAllJoinedActs(@Param("user_id")Long userId);
	
	//
	public ActivityJoinedUser getByUserIdActId(@Param("userId") Long userId,@Param("activityId") Long activityId);
}
