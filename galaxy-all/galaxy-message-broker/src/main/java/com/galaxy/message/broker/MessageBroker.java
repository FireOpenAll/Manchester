package com.galaxy.message.broker;

import com.lepeng.im.message.Message;

public interface MessageBroker {
	
	public boolean receive(Message<?> message);

}
