package com.galaxy.dal.activity.mapper;

import java.util.List;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;

public interface ActivityJoinedUsersMapper extends
		BaseMapper<ActivityJoinedUsers> {
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId);

	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,
			Long fromId, Long size);
}
