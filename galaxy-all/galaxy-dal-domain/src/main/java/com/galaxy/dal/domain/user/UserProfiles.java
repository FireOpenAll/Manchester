package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

public class UserProfiles extends BaseDomain {
	Long userId;
	String key;
	String value;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
