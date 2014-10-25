package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class ActivityLikedUsers extends BaseDomain {
	private Long userId; 
	private Long activityId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


}
