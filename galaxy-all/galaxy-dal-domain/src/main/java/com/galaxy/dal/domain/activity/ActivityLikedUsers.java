package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class ActivityLikedUsers extends BaseDomain {
	private String userId; 
	private Long activityId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


}
