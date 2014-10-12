package com.galaxy.message.service.test;

import org.junit.Test;

import com.galaxy.message.service.MessageSendService;
import com.galaxy.message.service.impl.MqttMessageSendServiceImpl;
import com.lepeng.im.message.json.JsonP2PMessage;

public class MessageSendServiceTest {
	MessageSendService messageSendService=new MqttMessageSendServiceImpl();
	@Test
	public void testSend1() {
		JsonP2PMessage message=new JsonP2PMessage();
		message.setToId(1L);
		message.setContent("Hello world!");
		message.setFromId(11111L);
		message.setMessageType(1);
		
		messageSendService.sendP2PMessage(message);

	}
	@Test
	public void testSend2() {
		JsonP2PMessage message=new JsonP2PMessage();
		message.setToId(2L);
		message.setContent("Hello world!");
		message.setFromId(11111L);
		message.setMessageType(1);
		
		messageSendService.sendP2PMessage(message);

	}
	@Test
	public void testJson() {
		JsonP2PMessage message=new JsonP2PMessage();
		message.setToId(1L);
		message.setContent("Hello world!");
		message.setFromId(11111L);
		message.setMessageType(1);
		
		System.out.println(message);

	}
}
