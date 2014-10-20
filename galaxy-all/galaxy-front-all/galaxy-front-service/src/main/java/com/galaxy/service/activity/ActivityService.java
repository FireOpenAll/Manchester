package com.galaxy.service.activity;

import java.util.List;
import java.util.Map;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.service.activity.form.ActivityForm;

public interface ActivityService {

	public Long create(ActivityForm form);
	
	public boolean modify(ActivityForm form);

	public boolean removeById(Long id);

	public boolean joinActivity(Long activityId, Long userId);

	public Activity getActivity(Long id);

	public List<Activity> list(Map parameters, int size);
	
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId);
	
	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,Long fromId,Long size);
	
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(Long user_id);

}
