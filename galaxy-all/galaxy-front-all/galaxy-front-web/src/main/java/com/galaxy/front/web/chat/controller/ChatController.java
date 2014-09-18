package com.galaxy.front.web.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "activity")
public class ChatController {
	@RequestMapping(value = "chat",method=RequestMethod.GET)
	public String post() {
		return "chat/chat";
	}
}
