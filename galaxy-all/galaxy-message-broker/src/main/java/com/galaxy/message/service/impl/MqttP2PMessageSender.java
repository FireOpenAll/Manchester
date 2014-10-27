package com.galaxy.message.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.galaxy.message.broker.MessageEvent;
import com.galaxy.message.queue.MessageQueueFactory;
import com.galaxy.message.service.MessageSender;
import com.lepeng.im.message.P2PMessage;

@Service("p2pMessageSender")
public class MqttP2PMessageSender implements MessageSender<P2PMessage<?>>,
		InitializingBean {
	final MQTT mqttClient = new MQTT();
	static final int THREAD_SIZE = 5;
	static final int CONNECTION_POOL_SIZE = 1000;
	static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(THREAD_SIZE);
	final List<P2PMessageConsumer> consumerList = new ArrayList<P2PMessageConsumer>();

	transient int hashSeed = 0;

	public MqttP2PMessageSender() {

	}

	@Override
	public void send(String queueName, P2PMessage<?> message) {
		MessageEvent event = new MessageEvent();
		event.queueName = queueName;
		event.message = message;
		int hashCode = hash(queueName);
		int index = Math.abs(hashCode % consumerList.size());
		P2PMessageConsumer consumer = consumerList.get(index);
		consumer.addEvent(event);
	}

	@SuppressWarnings("restriction")
	final int hash(Object k) {
		int h = hashSeed;
		if (0 != h && k instanceof String) {
			return sun.misc.Hashing.stringHash32((String) k);
		}

		h ^= k.hashCode();

		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
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

	class P2PMessageConsumer implements Runnable {
		final BlockingQueue<MessageEvent> messageQueue = MessageQueueFactory
				.createP2PEventQueue();
		final MqttP2PMessageSender sender;
		CallbackConnection connection = null;

		P2PMessageConsumer(MqttP2PMessageSender sender) {
			this.sender = sender;
		}

		public void addEvent(MessageEvent event) {
			messageQueue.add(event);
		}

		public void doSend(final String queueName, final P2PMessage<?> message) {
			try {

				getConnection().publish(queueName,
						message.toString().getBytes(), QoS.EXACTLY_ONCE, false,new  Callback<Void>(){

							@Override
							public void onSuccess(Void value) {
								System.out.println("+++++++++++++do sucess message+++++++++++++++"+value);
								
							}

							@Override
							public void onFailure(Throwable value) {
								System.out.println("--------------do failure send message---------------"+value);
								value.printStackTrace();
							}});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		CallbackConnection getConnection() {
			if (connection == null) {
				connection = mqttClient.callbackConnection();
				connection.connect(new Callback<Void>(){

					@Override
					public void onSuccess(Void value) {
						 
					}

					@Override
					public void onFailure(Throwable value) { 
						
					}});
			}
			return connection;
		}

		@Override
		public void run() {
			while (true) {
				try {
					MessageEvent event = messageQueue.take();
					doSend(event.queueName, (P2PMessage<?>) event.message);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			mqttClient.setClientId(UUID.randomUUID().toString());
			mqttClient.setHost("182.92.169.209", 1883);
			for (int i = 0; i < THREAD_SIZE; i++) {
				P2PMessageConsumer task = new P2PMessageConsumer(this);
				consumerList.add(task);
				threadPool.submit(task);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
