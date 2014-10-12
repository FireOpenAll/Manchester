package com.galaxy.message.service;

import com.lepeng.im.message.GroupMessage;
import com.lepeng.im.message.Notification;
import com.lepeng.im.message.P2PMessage;

public interface MessageSendService {
	void sendGroupMessage(GroupMessage<?> message);
	void sendP2PMessage(P2PMessage<?>  message);
	void sendNotification(Notification<?>  message);
}
