package com.lepeng.im.message.json;

import java.util.Map;

import com.google.gson.Gson;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.MessageType;

public class JsonDecoder {

	public static Message<?> decode(String json) {
		Gson gson = new Gson();
		Map<?, ?> values = gson.fromJson(json, Map.class);
		Integer typeInt = ((Number) values.get("messageType")).intValue();
		MessageType messageType = MessageType.toEnum(typeInt);
		if (messageType == null) {
			return null;
		}
		Message<?> message = null;
		switch (messageType) {
		case P2P:
			message = new JsonP2PMessage();
			break;
		case GROUP:
			message = new JsonGroupMessage();
			break;
		case NOTIFICATION:
			message = new JsonNotification();
			break;
		}
		message.decode(values);
		return message;

	}
	public static Message<?> decode(Map<?, ?> values) { 
		Integer typeInt = ((Number) values.get("messageType")).intValue();
		MessageType messageType = MessageType.toEnum(typeInt);
		if (messageType == null) {
			return null;
		}
		Message<?> message = null;
		switch (messageType) {
		case P2P:
			message = new JsonP2PMessage();
			break;
		case GROUP:
			message = new JsonGroupMessage();
			break;
		case NOTIFICATION:
			message = new JsonNotification();
			break;
		}
		message.decode(values);
		return message;

	}

}
