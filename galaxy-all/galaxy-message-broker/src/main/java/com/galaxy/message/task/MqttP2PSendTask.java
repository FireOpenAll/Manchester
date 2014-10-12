/**
 * 
 */
package com.galaxy.message.task;

import com.galaxy.message.queue.MessageQueue;
import com.galaxy.message.service.MessageSendService;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.P2PMessage;

/**
 * @author luolishu
 * 
 */
public class MqttP2PSendTask implements Runnable {
	final MessageQueue queue;
	final MessageSendService messageSendService;

	public MqttP2PSendTask(MessageQueue queue,
			MessageSendService messageSendService) {
		this.queue = queue;
		this.messageSendService = messageSendService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Message<?> msg = queue.take();
				if(msg==null){
					continue;
				}
				sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void sendMessage(Message<?> message) {
		messageSendService.sendP2PMessage((P2PMessage<?>) message);

	}

}
