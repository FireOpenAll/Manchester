/**
 * 
 */
package com.galaxy.message.broker.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.message.broker.MessageBroker;
import com.galaxy.message.queue.MessageQueue;
import com.galaxy.message.queue.MessageQueueFactory;
import com.galaxy.message.service.MessageSendService;
import com.galaxy.message.task.MqttGroupSendTask;
import com.galaxy.message.task.MqttNotificationSendTask;
import com.galaxy.message.task.MqttP2PSendTask;
import com.lepeng.im.message.GroupMessage;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.Notification;
import com.lepeng.im.message.P2PMessage;

/**
 * @author luolishu
 * 
 */
@Service
public class MqttMessageBroker implements MessageBroker, InitializingBean {
	static final MessageQueue p2pQueue = MessageQueueFactory.createQueue();
	static final MessageQueue groupQueue = MessageQueueFactory.createQueue();
	static final MessageQueue notificationQueue = MessageQueueFactory
			.createQueue();
	@Autowired
	MessageSendService messageSendService;
	ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(10);

	@Override
	public boolean receive(Message<?> message) {
		if (message instanceof P2PMessage) {
			return p2pQueue.add(message);
		}
		if (message instanceof GroupMessage) {
			return groupQueue.add(message);
		}
		if (message instanceof Notification) {
			return notificationQueue.add(message);
		}
		return false;

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		threadPool.submit(new MqttP2PSendTask(p2pQueue, messageSendService));
		threadPool
				.submit(new MqttGroupSendTask(groupQueue, messageSendService));
		threadPool.submit(new MqttNotificationSendTask(notificationQueue,
				messageSendService));
	}

	@Override
	public void register(Long userId) {
		// TODO Auto-generated method stub
		
	}

}
