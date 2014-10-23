/**
 * 
 */
package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 *
 */
public class ChatGroupApply extends BaseDomain {
	Long groupId;
	Long userId;
	String name;
	Long managerUserId;
	String applyReason;
	String rejectReason;
	Status status;
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
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
	public Long getManagerUserId() {
		return managerUserId;
	}
	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}
	 
	
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	} 
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}


	public static enum Status{
		INIT,
		REJECTED,
		CONFIRM,
		IGNORE;
	}

}
