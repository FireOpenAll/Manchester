package com.galaxy.front.web.rest.message;

import com.lepeng.im.message.Message;
import com.lepeng.im.message.json.JsonDecoder;

public class MessageController {

	public Object messages(String json) {
		Message<?> message=JsonDecoder.decode(json);
		return null;
	}

	public Object sendMessage() {
		return null;
	}

	public Object removeMessage() {
		return null;
	}

	public Object updateMessageRead() {
		return null;
	}

}
