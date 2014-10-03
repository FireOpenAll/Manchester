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
		mqtt.setHost("iot.eclipse.org", 1883);
		mqtt.setTracer(new Tracer() {
			@Override
			public void onReceive(MQTTFrame frame) { 
				System.out.println("recv: " + frame.messageType()+" content"+new String(frame.buffers[0].getData()));
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

		// Start add a listener to process subscription messages, and start the
		// resume the connection so it starts receiving messages from the
		// socket.
		connection.listener(new Listener() {
			public void onConnected() {
				System.out.println("connected");
			}

			public void onDisconnected() {
				System.out.println("disconnected");
			}

			public void onPublish(UTF8Buffer topic, Buffer payload,
					Runnable onComplete) {
				result.onSuccess(payload);
				onComplete.run();
			}

			public void onFailure(Throwable value) {
				System.out.println("failure: " + value);
				result.onFailure(value);
				connection.disconnect(null);
			}
		}); 
		connection.connect(new Callback<Void>() {
			// Once we connect..
			public void onSuccess(Void v) {

				// Subscribe to a topic foo
				Topic[] topics = { new Topic(utf8("foo"), QoS.AT_LEAST_ONCE) };
				connection.subscribe(topics, new Callback<byte[]>() {
					public void onSuccess(byte[] value) {
						// Once subscribed, publish a message on the same topic.
						connection.publish("foo", "Hello".getBytes(),
								QoS.AT_LEAST_ONCE, false, null);
					}

					public void onFailure(Throwable value) {
						result.onFailure(value);
						connection.disconnect(null);
					}
				});

			}

			public void onFailure(Throwable value) {
				result.onFailure(value);
			}
		});
		while (true) {
			for (int i = 0; i < 10; i++) {
				connection.publish("foo", "Hello".getBytes(),
						QoS.AT_LEAST_ONCE, false, null);
			} 
			Thread.sleep(1000L);
		}

	}
}