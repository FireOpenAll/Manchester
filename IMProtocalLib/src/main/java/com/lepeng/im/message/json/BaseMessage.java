package com.lepeng.im.message.json;

import com.google.gson.Gson;
import com.lepeng.im.message.Message;

public abstract class BaseMessage implements Message<String> {
	protected Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		Gson gson=new Gson();
		return gson.toJson(this);
	}
}
