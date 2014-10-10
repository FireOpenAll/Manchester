package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class ActivityJoinedGroup extends BaseDomain {
	Long userId;
	String groupName;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
