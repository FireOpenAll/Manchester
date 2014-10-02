package com.galaxy.service.activity;

import java.util.List;
import java.util.Map;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.service.activity.form.ActivityForm;

public interface ActivityService {

	public Long create(ActivityForm form);
	
	public boolean modify(ActivityForm form);

	public boolean removeById(Long id);

	public boolean joinActivity(Long activityId, Long userId);

	public Activity getActivity(Long id);

	public List<Activity> list(Map parameters, int size);
	
	

}
