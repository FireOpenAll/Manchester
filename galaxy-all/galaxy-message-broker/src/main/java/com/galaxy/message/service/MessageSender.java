package com.galaxy.message.service;

import com.lepeng.im.message.Message;

public interface MessageSender<T extends Message<?>> {
	
	public void send(String queueName,T message);

}
