package com.galaxy.mqtt.test;

import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
import org.junit.Test;

public class MQTTClientTest {
	@Test
	public void testPub() throws Exception{
		MQTT mqtt = new MQTT(); 
		// or 
		mqtt.setHost("tcp://iot.eclipse.org:1883");
		mqtt.setClientId("testid");
		final CallbackConnection connection=mqtt.callbackConnection(); 
		connection.connect(new Callback(){

			@Override
			public void onSuccess(Object value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(Throwable value) {
				// TODO Auto-generated method stub
				
			}});
		Topic[] topics = {new Topic("foo", QoS.AT_LEAST_ONCE)};
		connection.subscribe(topics, new Callback<byte[]>() {
            public void onSuccess(byte[] qoses) {
                // The result of the subcribe request.
            }
            public void onFailure(Throwable value) {
                
            }
        });
	}

}
