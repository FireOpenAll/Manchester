package com.galaxy.message.queue;

import com.lepeng.im.message.Message;

public interface MessageQueue {
	
	public boolean add(Message<?> msg);
	
	public Message<?> take();

}
