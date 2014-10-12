package com.galaxy.message.broker.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.message.broker.MessageBroker;
import com.galaxy.message.broker.impl.MqttMessageBroker;
import com.lepeng.im.message.json.JsonP2PMessage;
@ContextConfiguration(locations = { "/spring/message-broker-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageBrokerTest {
	MessageBroker messageBroker = new MqttMessageBroker();

	@Test
	public void testReceive() throws Exception {
		for (int i = 1; i < 1000; i++) {
			JsonP2PMessage message = new JsonP2PMessage();
			message.setToId(1L);
			message.setContent("Hello world!"+i);
			message.setFromId(11111L);
			message.setMessageType(1);

			messageBroker.receive(message);
			//Thread.sleep(1000L);
		}

		while (true) {
			Thread.sleep(111111L);
		}
	}

}
