package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;

public interface ActivityJoinedUsersMapper extends
		BaseMapper<ActivityJoinedUsers> {
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId);

	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,
			Long fromId, Long size);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(@Param("user_id")Long user_id);
}
