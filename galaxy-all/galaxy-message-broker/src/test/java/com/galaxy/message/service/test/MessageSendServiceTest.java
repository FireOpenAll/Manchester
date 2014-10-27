package com.galaxy.message.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.message.service.MessageSendService;
import com.lepeng.im.message.json.JsonP2PMessage;
@ContextConfiguration(locations = { "/spring/message-broker-config.xml", "/spring/dao.xml",
"/spring/datasource-config.xml"  })
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageSendServiceTest {
	@Autowired
	MessageSendService messageSendService ;

	@Test
	public void testSend1() {
		JsonP2PMessage message = new JsonP2PMessage();
		message.setToId(1L);
		message.setContent("Hello world!");
		message.setFromId(11111L);
		message.setMessageType(1);

		messageSendService.sendP2PMessage(message);

	}

	@Test
	public void testSend2() throws InterruptedException {
		for (long i = 0; i < 5000; i++) {
			JsonP2PMessage message = new JsonP2PMessage();
			message.setToId(i%5);
			message.setContent("Hello world!" + i);
			message.setFromId(11111L);
			message.setMessageType(1);
			

			messageSendService.sendP2PMessage(message);
		}
		Thread.sleep(10000000000L);

	}

	@Test
	public void testJson() {
		JsonP2PMessage message = new JsonP2PMessage();
		message.setToId(1L);
		message.setContent("Hello world!");
		message.setFromId(11111L);
		message.setMessageType(1);

		System.out.println(message);

	}
}
