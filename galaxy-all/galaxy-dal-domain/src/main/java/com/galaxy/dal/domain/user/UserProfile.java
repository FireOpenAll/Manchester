package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

public class UserProfile extends BaseDomain {
	private Long userId;
	private String property;
	private String propertyValue;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}


}
