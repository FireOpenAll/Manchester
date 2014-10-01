/**
 * 
 */
package com.galaxy.dal.domain.usergroup;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 * 
 */
public class GroupApply extends BaseDomain {
	Long groupId;
	Long userId;
	Status status;
	Long auditUserId;
	String message;
	String reason;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(Long auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	enum Status {
		/**
		 * 初始状态
		 */
		INIT,
		/**
		 * 审核通过
		 */
		AUDIT;

	}
}
