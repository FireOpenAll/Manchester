package com.galaxy.dal.domain.usergroup;

import com.galaxy.dal.domain.BaseDomain;

public class GroupMembers extends BaseDomain {

	Long userId;
	String memberName;
	Long groupId;
	GroupRole role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public GroupRole getRole() {
		return role;
	}

	public void setRole(GroupRole role) {
		this.role = role;
	}

}
