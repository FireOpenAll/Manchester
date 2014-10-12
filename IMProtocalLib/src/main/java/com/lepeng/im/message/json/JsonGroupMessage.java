/**
 * 
 */
package com.lepeng.im.message.json;

import java.util.Map;

import com.google.gson.Gson;
import com.lepeng.im.message.GroupMessage;

/**
 * @author luolishu
 * 
 */
public class JsonGroupMessage extends BaseMessage implements GroupMessage<String>{ 
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

	public JsonGroupMessage decode(String payload) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(payload, Map.class);
		return decode(values);
	}

	public JsonGroupMessage decode(Map<?, ?> values) {
		groupId = getLong((Number) values.get("groupId"));
		fromId = getLong((Number) values.get("fromId"));
		id = getLong((Number) values.get("id"));
		messageType = getInteger((Number) values.get("messageType"));
		content = (String) values.get("content");
		return this;
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
 

}
