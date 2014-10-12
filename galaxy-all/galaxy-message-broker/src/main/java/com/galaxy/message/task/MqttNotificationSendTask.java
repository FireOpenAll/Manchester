/**
 * 
 */
package com.galaxy.message.task;

import com.galaxy.message.queue.MessageQueue;
import com.galaxy.message.service.MessageSendService;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.Notification;

/**
 * @author luolishu
 * 
 */
public class MqttNotificationSendTask implements Runnable {
	final MessageQueue queue;
	final MessageSendService messageSendService;

	public MqttNotificationSendTask(MessageQueue queue,
			MessageSendService messageSendService) {
		this.queue = queue;
		this.messageSendService = messageSendService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Message<?> msg = queue.take();
				sendMessage(msg);
			} catch (Exception e) {

			}
		}

	}

	private void sendMessage(Message<?> message) {
		Notification<?> notification = (Notification<?>) message;
		messageSendService.sendNotification(notification);

	}

}
