package com.galaxy.message.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.galaxy.message.broker.MessageEvent;

public class MessageQueueFactory {
	static final List<BlockingQueue> p2pQueueList = new LinkedList<BlockingQueue>();
	static final List<BlockingQueue> groupQueueList = new LinkedList<BlockingQueue>();
	static {
		Thread t = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(60000L);
						int j = 0;
						for (int i = 0; i < p2pQueueList.size(); i++) {
							if (p2pQueueList.get(i).size() > 0) {
								j++;
								System.out
										.println(p2pQueueList.get(i).hashCode()
												+ "======================p2p========================queue size="
												+ p2pQueueList.get(i).size());

							}
						}
						if (j == 0) {
							System.out
									.println("********************all p2p sent***********************");
							
						}
						j = 0;
						for (int i = 0; i < groupQueueList.size(); i++) {
							if (groupQueueList.get(i).size() > 0) {
								j++;
								System.out
										.println(groupQueueList.get(i)
												.hashCode()
												+ "=====================group=========================queue size="
												+ groupQueueList.get(i).size());

							}
						}
						if (j == 0) {
							System.out
									.println("********************all group sent***********************");
							j = 0;
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}

	public static MessageQueue createQueue() {
		return new BlockingMessageQueue();
	}

	public static BlockingQueue<MessageEvent> createP2PEventQueue() {
		BlockingQueue<MessageEvent> queue = new LinkedBlockingQueue<MessageEvent>(
				100000);
		p2pQueueList.add(queue);
		return queue;
	}

	public static BlockingQueue<MessageEvent> createGroupEventQueue() {
		BlockingQueue<MessageEvent> queue = new LinkedBlockingQueue<MessageEvent>(
				100000);
		groupQueueList.add(queue);
		return queue;
	}

}
