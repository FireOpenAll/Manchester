package com.lepeng.im.message.json;

import java.util.Map;

import com.google.gson.Gson;

public class Notification extends BaseMessage {
	Long id;
	Integer messageType;
	String content;
 
	public Notification decode(String payload) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(payload, Map.class);
		return decode(values);
	}
	public Notification decode(Map<?, ?> values) {
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

	@Override
	public String toString() {
		return "Notification [id=" + id + ", messageType=" + messageType
				+ ", content=" + content + "]";
	}
 

}
