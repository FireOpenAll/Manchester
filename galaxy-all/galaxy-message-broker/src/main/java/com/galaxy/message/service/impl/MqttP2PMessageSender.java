package com.galaxy.message.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.springframework.stereotype.Service;

import com.galaxy.message.broker.MessageEvent;
import com.galaxy.message.queue.MessageQueueFactory;
import com.galaxy.message.service.MessageSender;
import com.lepeng.im.message.P2PMessage;
@Service("p2pMessageSender")
public class MqttP2PMessageSender implements MessageSender<P2PMessage<?>> {
	static final MQTT mqttClient = new MQTT();
	static final int THREAD_SIZE=50;
	static final int CONNECTION_POOL_SIZE=1000;
	static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_SIZE);
	final List<P2PMessageConsumer> consumerList = new ArrayList<P2PMessageConsumer>();
	
	BlockingQueue<BlockingConnection> connectionPool=new LinkedBlockingQueue<BlockingConnection>(CONNECTION_POOL_SIZE);
	static {
		try {
			mqttClient.setClientId(UUID.randomUUID().toString());
			mqttClient.setHost("182.92.169.209", 1883);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	transient int hashSeed = 0;

	public MqttP2PMessageSender() {
		for (int i = 0; i < THREAD_SIZE; i++) {
			P2PMessageConsumer task=new P2PMessageConsumer(this);
			consumerList.add(task); 
			threadPool.submit(task);
		}
	}

	@Override
	public void send(String queueName, P2PMessage<?> message) {
		MessageEvent event=new MessageEvent();
		event.queueName=queueName;
		event.message=message; 
		int hashCode=hash(queueName);
		int index=Math.abs(hashCode%consumerList.size()); 
		P2PMessageConsumer consumer=consumerList.get(index);
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

	public void doSend(String queueName, P2PMessage<?> message) {
		BlockingConnection connection = this.getConnection(); 
		try {
			connection.publish(queueName, message.toString().getBytes(),
					QoS.EXACTLY_ONCE, false);
			connectionPool.offer(connection);//使用后归还
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BlockingConnection getConnection() {
		BlockingConnection connection = connectionPool.poll();
		if(connection==null){
			connection=mqttClient.blockingConnection();
			try {
				connection.connect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return connection;
	}
 

	class P2PMessageConsumer implements Runnable {
		final BlockingQueue<MessageEvent> messageQueue = MessageQueueFactory.createP2PEventQueue();
		final MqttP2PMessageSender sender;

		P2PMessageConsumer(MqttP2PMessageSender sender) {
			this.sender = sender;
		}
		
		public void addEvent(MessageEvent event){
			messageQueue.add(event);
		}

		@Override
		public void run() {
			while (true) {
				try {
					MessageEvent event = messageQueue.take();
					sender.doSend(event.queueName, (P2PMessage<?>) event.message);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
	
}
