package com.galaxy.front.web.rest.message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/message")
public class MessageController {

	public Object messages() {
		return null;
	}
	@RequestMapping(value = "api/v1/message")
	public Object sendMessage(String message) {
		return null;
	}

	public Object removeMessage() {
		return null;
	}

	public Object updateMessageRead() {
		return null;
	}

}
