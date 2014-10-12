package com.galaxy.message.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.lepeng.im.message.Message;

public class BlockingMessageQueue implements MessageQueue {
	BlockingQueue<Message<?>> queue=new ArrayBlockingQueue<Message<?>>(10000);

	@Override
	public boolean add(Message<?> msg) { 
		return queue.offer(msg);
	}

	@Override
	public Message<?> take() {
		// TODO Auto-generated method stub
		try {
			
			Message<?> message=null;
			message=queue.take();
			return message;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}
