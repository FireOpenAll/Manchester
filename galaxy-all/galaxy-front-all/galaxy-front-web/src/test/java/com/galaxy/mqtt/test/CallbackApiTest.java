package com.galaxy.mqtt.test;

/**
 * Copyright (C) 2010-2012, FuseSource Corp.  All rights reserved.
 *
 *     http://fusesource.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.fusesource.hawtbuf.Buffer.utf8;

import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.Listener;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.Promise;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
import org.fusesource.mqtt.client.Tracer;
import org.fusesource.mqtt.codec.MQTTFrame;
import org.junit.Test;

/**
 * <p>
 * </p>
 * 
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
public class CallbackApiTest {
	@Test
	public void testInterface() throws Exception {
		final Promise<Buffer> result = new Promise<Buffer>();
		MQTT mqtt = new MQTT();
		mqtt.setHost("182.92.169.209", 1883);
		mqtt.setClientId("ttt");
		mqtt.setTracer(new Tracer() {
			@Override
			public void onReceive(MQTTFrame frame) { 
				System.out.println("recv: " + frame);
			}

			@Override
			public void onSend(MQTTFrame frame) {
				System.out.println("send: " + frame);
			}

			@Override
			public void debug(String message, Object... args) {
				System.out.println(String.format("debug: " + message, args));
			}
		});

		final CallbackConnection connection = mqtt.callbackConnection();
 
		connection.connect(null);
		while (true) {
			for (int i = 0; i < 10; i++) {
				connection.publish("foo/1",(i+"Hello").getBytes(),
						QoS.AT_LEAST_ONCE, false, null);
			} 
			Thread.sleep(1000L);
		}

	}
}