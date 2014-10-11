package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

public class Favorites extends BaseDomain {
	Long userId;
	Type type;
	Long ref_id;
	int status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getRef_id() {
		return ref_id;
	}

	public void setRef_id(Long ref_id) {
		this.ref_id = ref_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public enum Type {
		ACTIVITY

	}
}
