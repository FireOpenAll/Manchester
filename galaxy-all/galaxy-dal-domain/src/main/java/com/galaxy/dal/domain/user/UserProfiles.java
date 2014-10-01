package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

public class UserProfiles extends BaseDomain {
	Long userId;
	String name;
	String value;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	} 

}
