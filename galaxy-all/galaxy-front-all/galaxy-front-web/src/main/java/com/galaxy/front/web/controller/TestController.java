package com.galaxy.front.web.controller;
 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galaxy.dal.chat.mapper.ChatGroupMemberMapper;
import com.galaxy.dal.domain.DBStatus;
import com.galaxy.dal.domain.chat.ChatGroupMember;
import com.galaxy.dal.domain.chat.ChatGroupRole;
import com.galaxy.message.broker.MessageBroker;
import com.lepeng.im.message.json.JsonGroupMessage;

@Controller 
public class TestController {
	@Autowired
	MessageBroker messageBroker;
	@Autowired
	ChatGroupMemberMapper chatGroupMemberMapper;
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String test3(){
		return "test3";
	}
	@RequestMapping(value="/test4", method=RequestMethod.GET)
	public String test4(){
		return "test4";
	}
	@RequestMapping(value="/test5", method=RequestMethod.GET)
	public String test5(){
		return "test5";
	}
	@RequestMapping(value="/test6", method=RequestMethod.GET)
	public String test6(){
		return "test6";
	}
	@RequestMapping(value="/test7", method=RequestMethod.GET)
	public String test7(){
		for (int i = 1; i < 1000; i++) {
			JsonGroupMessage message = new JsonGroupMessage();
			message.setGroupId(2L);
			message.setFromId((long)i);
			message.setContent("Hello world!"+i);
			message.setFromId(11111L);
			message.setMessageType(2);
			message.setCreatedTime(System.currentTimeMillis());

			messageBroker.receive(message);
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "test7";
	}
	@RequestMapping(value="/testInsert", method=RequestMethod.GET)
	public String testInsert(){
		for (int i = 1; i < 100; i++) {
			ChatGroupMember member = new ChatGroupMember();
			member.setCreatedTime(new Date());
			member.setDescription("fdafasdjlf");
			member.setEmail("fdasfasfdas"+i);
			member.setGroupId(2L);
			member.setPhone("42349821");
			member.setRole(ChatGroupRole.MEMBER);
			member.setStatus(DBStatus.INIT);
			member.setUserId((long)i);
			member.setUserName("fdaslfj");

			chatGroupMemberMapper.insert(member);
		}
		return "test7";
	}
}
