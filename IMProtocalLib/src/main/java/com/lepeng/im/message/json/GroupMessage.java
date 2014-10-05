/**
 * 
 */
package com.lepeng.im.message.json;

import java.util.Map;

import com.google.gson.Gson;

/**
 * @author luolishu
 * 
 */
public class GroupMessage extends BaseMessage {
	Long id;
	Long groupId;
	Long fromId;
	Integer messageType;
	String content;

	public Long getGroupId() {
		return groupId;
	}

	public Long getFromId() {
		return fromId;
	}

	public GroupMessage decode(String payload) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(payload, Map.class);
		return decode(values);
	}

	public GroupMessage decode(Map<?, ?> values) {
		groupId = getLong((Number) values.get("groupId"));
		fromId = getLong((Number) values.get("fromId"));
		id = getLong((Number) values.get("id"));
		messageType = getInteger((Number) values.get("messageType"));
		content = (String) values.get("content");
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", groupId=" + groupId + ", fromId="
				+ fromId + ", messageType=" + messageType + ", content="
				+ content + "]";
	}

}
