/**
 * 
 */
package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;
import com.galaxy.dal.domain.DBStauts;

/**
 * @author luolishu
 * 
 */
public class ChatGroupMember extends BaseDomain {
	Long groupId;
	Long userId;
	String phone;
	String email;
	String description;
	DBStauts status;
	ChatGroupRole role;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DBStauts getStatus() {
		return status;
	}
	public void setStatus(DBStauts status) {
		this.status = status;
	}
	public ChatGroupRole getRole() {
		return role;
	}
	public void setRole(ChatGroupRole role) {
		this.role = role;
	}
	
	
	
}
