package com.galaxy.message.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.galaxy.message.broker.MessageEvent;
import com.galaxy.message.queue.MessageQueueFactory;
import com.galaxy.message.service.MessageSender;
import com.lepeng.im.message.GroupMessage;

@Service("groupMessageSender")
public class MqttGroupMessageSender implements MessageSender<GroupMessage<?>> ,InitializingBean{
	 final MQTT mqttClient = new MQTT();
	static final int THREAD_SIZE = 5; 
	static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(THREAD_SIZE);
	final List<GroupMessageConsumer> consumerList = new ArrayList<GroupMessageConsumer>(); 
	transient int hashSeed = 0;

	public MqttGroupMessageSender() {
		
	}

	@Override
	public void send(String queueName, GroupMessage<?> message) {
		MessageEvent event = new MessageEvent();
		event.queueName = queueName;
		event.message = message;
		int hashCode = hash(queueName);
		int index = Math.abs(hashCode % consumerList.size());
		GroupMessageConsumer consumer = consumerList.get(index);
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

	

	class GroupMessageConsumer implements Runnable {
		final BlockingQueue<MessageEvent> messageQueue = MessageQueueFactory
				.createGroupEventQueue();
		final MqttGroupMessageSender sender;
	    CallbackConnection connection = null;

		GroupMessageConsumer(MqttGroupMessageSender sender) {
			this.sender = sender; 
		}

		public void addEvent(MessageEvent event) {
			messageQueue.add(event);
		}

		public void doSend(final String queueName, final GroupMessage<?> message) {
			try {

				getConnection().publish(queueName,
						message.toString().getBytes(), QoS.EXACTLY_ONCE, false,new  Callback<Void>(){

							@Override
							public void onSuccess(Void value) {
								System.out.println(Thread.currentThread()+"send sucess queueName＝"+queueName+" msg="+message);
								
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
						System.out.println("+++++++++++++connection success+++++++++++++++"+value);
						
					}

					@Override
					public void onFailure(Throwable value) { 
						System.out.println("--------------connection---------------"+value);
						value.printStackTrace();
					}});
			}
			return connection;
		}
		@Override
		public void run() {
			while (true) {
				try {
					MessageEvent event = messageQueue.take(); 
					doSend(event.queueName, (GroupMessage<?>) event.message); 
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
			mqttClient.setHost("127.0.0.1", 1883); 
			for (int i = 0; i < THREAD_SIZE; i++) {
				GroupMessageConsumer task = new GroupMessageConsumer(this);
				consumerList.add(task);
				threadPool.submit(task);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
