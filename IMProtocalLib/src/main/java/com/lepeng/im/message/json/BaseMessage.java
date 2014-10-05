package com.lepeng.im.message.json;

import com.google.gson.Gson;
import com.lepeng.im.message.Message;

public abstract class BaseMessage implements Message<String> {
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
}
