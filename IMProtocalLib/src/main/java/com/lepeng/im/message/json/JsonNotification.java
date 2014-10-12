package com.lepeng.im.message.json;

import java.util.Map;

import com.google.gson.Gson;
import com.lepeng.im.message.Notification;

public class JsonNotification extends BaseMessage implements Notification<String>{
	Long toId;
	Integer messageType;
	String content;
 
	public JsonNotification decode(String payload) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(payload, Map.class);
		return decode(values);
	}
	public JsonNotification decode(Map<?, ?> values) {
		toId = getLong((Number) values.get("toId"));
		messageType = getInteger((Number) values.get("messageType"));
		content = (String) values.get("content");
		return this;
	}

	 

	public Long getToId() {
		return toId;
	}
	public void setToId(Long toId) {
		this.toId = toId;
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

	 

}
