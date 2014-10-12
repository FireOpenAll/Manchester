/**
 * 
 */
package com.galaxy.message.task;

import com.galaxy.message.queue.MessageQueue;
import com.galaxy.message.service.MessageSendService;
import com.lepeng.im.message.GroupMessage;
import com.lepeng.im.message.Message;

/**
 * @author luolishu
 * 
 */
public class MqttGroupSendTask implements Runnable {
	final MessageQueue queue;
	final MessageSendService messageSendService;

	public MqttGroupSendTask(MessageQueue queue,
			MessageSendService messageSendService) {
		this.queue = queue;
		this.messageSendService = messageSendService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Message<?> msg = queue.take();
				sendMessage((GroupMessage<?>) msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void sendMessage(GroupMessage<?> message) {
		messageSendService.sendGroupMessage(message);

	}

}
