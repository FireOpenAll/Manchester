package com.galaxy.message.queue;

public class MessageQueueFactory {
	
	public static MessageQueue createQueue(){
		return new BlockingMessageQueue();
	}

}
