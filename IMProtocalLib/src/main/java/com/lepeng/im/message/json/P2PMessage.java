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
public class P2PMessage extends BaseMessage {
	Long id;
	Long toId;
	Long fromId;
	Integer messageType;
	String content;

	public Long getToId() {
		return toId;
	}

	public Long getFromId() {
		return fromId;
	}

	public P2PMessage decode(String payload) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(payload, Map.class);
		return decode(values);
	}

	public P2PMessage decode(Map<?, ?> values) {
		toId = getLong((Number) values.get("toId"));
		fromId = getLong((Number) values.get("fromId"));
		id = getLong((Number)values.get("id"));
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

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	@Override
	public String toString() {
		return "P2PMessage [id=" + id + ", toId=" + toId + ", fromId=" + fromId
				+ ", messageType=" + messageType + ", content=" + content + "]";
	}

}
