package com.lepeng.im.message.json;

import java.util.Date;

import com.google.gson.Gson;
import com.lepeng.im.message.Message;

public abstract class BaseMessage implements Message<String> {
	protected Long messageId;
	protected Long createdTime=(new Date().getTime());
	public String encode() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	protected Long getLong(Number number) {
		if (number == null){
			return null;
		}
		return number.longValue();
	}

	protected Integer getInteger(Number number) {
		if (number == null){
			return null;
		}
		return number.intValue();
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long id) {
		this.messageId = id;
	}
	
	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		Gson gson=new Gson();
		return gson.toJson(this);
	}
}
