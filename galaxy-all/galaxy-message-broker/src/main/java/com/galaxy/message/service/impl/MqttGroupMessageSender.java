package com.galaxy.message.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.springframework.stereotype.Service;

import com.galaxy.message.service.MessageSender;
import com.lepeng.im.message.GroupMessage;
@Service("groupMessageSender")
public class MqttGroupMessageSender implements MessageSender<GroupMessage<?>> {
	static final MQTT mqttClient = new MQTT();
	static final int THREAD_SIZE=50;
	static final int CONNECTION_POOL_SIZE=100;
	static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_SIZE);
	final List<MessageConsumer> consumerList = new ArrayList<MessageConsumer>();
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

	public MqttGroupMessageSender() {
		for (int i = 0; i < 50; i++) {
			MessageConsumer task=new MessageConsumer(this);
			consumerList.add(task); 
			threadPool.submit(task);
		}
	}

	@Override
	public void send(String queueName, GroupMessage<?> message) {
		MessageEvent event=new MessageEvent();
		event.queueName=queueName;
		event.message=message; 
		int hashCode=hash(queueName);
		int index=Math.abs(hashCode%consumerList.size());
		MessageConsumer consumer=consumerList.get(index);
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

	public void doSend(String queueName, GroupMessage<?> message) {
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

	class MessageEvent {
		String queueName;
		GroupMessage<?> message;

	}

	class MessageConsumer implements Runnable {
		BlockingQueue<MessageEvent> messageQueue = new LinkedBlockingQueue<MessageEvent>(100000);
		final MqttGroupMessageSender sender;
		List<GroupMessage<?>> sendList=new LinkedList<GroupMessage<?>>();
		Map<String,List<GroupMessage<?>>> sendQueueMap=new HashMap<String,List<GroupMessage<?>>>();

		MessageConsumer(MqttGroupMessageSender sender) {
			this.sender = sender;
		}
		
		public void addEvent(MessageEvent event){
			messageQueue.add(event);
		}
		private List<GroupMessage<?>> getSendList(String queueName){
			List<GroupMessage<?>> messageList=sendQueueMap.get(queueName);
			if(messageList==null){
				messageList=new LinkedList<GroupMessage<?>>();
				sendQueueMap.put(queueName, messageList);
			}
			return messageList;
		}
		
		private void printSendInfo(){
			Set<Entry<String,List<GroupMessage<?>>>> entrySet=sendQueueMap.entrySet();
			for(Entry<String,List<GroupMessage<?>>> entry:entrySet){
				String queueName=entry.getKey();
				List<GroupMessage<?>> messageList=entry.getValue();
				StringBuilder sb=new StringBuilder("queue name="+queueName+" size="+messageList.size()+" send content:=================================================\n");
				for(GroupMessage<?> msg:messageList){
					sb.append(msg).append("\n");
				}
				System.out.println(sb.toString());
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					MessageEvent event = messageQueue.take();
					System.out.println("send queue="+event.queueName+" message="+event.message);
					sender.doSend(event.queueName, event.message);
					//List<GroupMessage<?>> messageList=getSendList(event.queueName);
					//messageList.add(event.message);
					//printSendInfo();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
