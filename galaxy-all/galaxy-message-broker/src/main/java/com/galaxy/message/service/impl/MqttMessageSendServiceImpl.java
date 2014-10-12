package com.galaxy.message.service.impl;

import java.net.URISyntaxException;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.springframework.stereotype.Service;

import com.galaxy.message.service.MessageSendService;
import com.galaxy.message.utils.MessageUtils;
import com.lepeng.im.message.GroupMessage;
import com.lepeng.im.message.Notification;
import com.lepeng.im.message.P2PMessage;

@Service
public class MqttMessageSendServiceImpl implements MessageSendService {

	static final MQTT mqttClient = new MQTT();

	static {
		try {
			mqttClient.setHost("182.92.169.209", 1883);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendGroupMessage(GroupMessage<?> message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendP2PMessage(P2PMessage<?> message) {
		BlockingConnection connection = this.getConnection();
		try {
			connection.publish(MessageUtils.generateQueueId(message.getToId()),
					message.toString().getBytes(), QoS.EXACTLY_ONCE, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendNotification(Notification<?> message) {
		// TODO Auto-generated method stub

	}

	private BlockingConnection getConnection() {
		BlockingConnection connection = mqttClient.blockingConnection();
		try {
			connection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
