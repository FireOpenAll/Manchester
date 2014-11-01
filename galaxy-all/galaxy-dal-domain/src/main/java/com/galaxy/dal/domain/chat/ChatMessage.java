package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;

public class ChatMessage extends BaseDomain {
	Long messageType;
	Long userId;
	Long fromId;
	Long toId;
	Long groupId;
	String body;
	int status;
	public Long getMessageType() {
		return messageType;
	}
	public void setMessageType(Long messageType) {
		this.messageType = messageType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Long getFromId() {
		return fromId;
	}
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}
	public Long getToId() {
		return toId;
	}
	public void setToId(Long toId) {
		this.toId = toId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public interface Status{
		int INIT=0;
		int SEND=1;
		int OFFLINE=2;
		int REMOVE=99;
		
	}

}
