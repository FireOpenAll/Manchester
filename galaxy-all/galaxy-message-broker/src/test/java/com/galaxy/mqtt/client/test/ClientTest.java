package com.galaxy.mqtt.client.test;

import java.net.URISyntaxException;
import java.util.UUID;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.junit.Test;

public class ClientTest {
	static final MQTT mqttClient = new MQTT();
	static {
		mqttClient.setClientId(UUID.randomUUID().toString());
		try {
			mqttClient.setHost("182.92.169.209", 1883);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Test
	public void test() throws Exception {
		BlockingConnection connection = mqttClient.blockingConnection();
		try {
			connection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s=null;
		for (int i = 0; i < 10000000; i++) {
			s=(Math.random()+"helllo");
			connection.publish("user/"+(i%11), s.getBytes(),
						QoS.EXACTLY_ONCE, false);
			System.out.println(s);
		}
	}

}
