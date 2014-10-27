package com.galaxy.message.broker;

import com.lepeng.im.message.Message;

public class MessageEvent {
	public String queueName;
	public Message<?> message;
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public Message<?> getMessage() {
		return message;
	}
	public void setMessage(Message<?> message) {
		this.message = message;
	}
}
