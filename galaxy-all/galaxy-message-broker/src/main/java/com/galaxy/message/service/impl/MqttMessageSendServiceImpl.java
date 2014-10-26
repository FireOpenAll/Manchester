package com.galaxy.message.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.chat.mapper.ChatGroupMemberMapper;
import com.galaxy.dal.domain.chat.ChatGroupMember;
import com.galaxy.message.service.MessageSendService;
import com.galaxy.message.service.MessageSender;
import com.galaxy.message.utils.MessageUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lepeng.im.message.GroupMessage;
import com.lepeng.im.message.Notification;
import com.lepeng.im.message.P2PMessage;

@Service
public class MqttMessageSendServiceImpl implements MessageSendService,
		InitializingBean {
	static final String GROUP_CACHE_KEY_PREFIX="_group";

	@Autowired
	ChatGroupMemberMapper chatGroupMemberMapper;
	@Resource(name = "p2pMessageSender")
	MessageSender<P2PMessage<?>> p2pMessageSender;
	@Resource(name = "groupMessageSender")
	MessageSender<GroupMessage<?>> groupMessageSender;
	LoadingCache<String, List<ChatGroupMember>> localGroupCache;

	@Override
	public void sendGroupMessage(GroupMessage<?> message) {
		Long groupId = message.getGroupId();
		String key=GROUP_CACHE_KEY_PREFIX+groupId;
		List<ChatGroupMember> groupMemberList=null;
		try {
			groupMemberList = localGroupCache.get(key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (groupMemberList == null || groupMemberList.isEmpty()) {
			return;
		}
		for (ChatGroupMember member : groupMemberList) {
			String queueName = MessageUtils.generateQueueId(member.getUserId());
			groupMessageSender.send(queueName, message);
		}
	}

	private List<ChatGroupMember> getGroupMembers(Long groupId) {// 做多级缓存
		return chatGroupMemberMapper.getGroupMembers(groupId);
	}

	@Override
	public void sendP2PMessage(P2PMessage<?> message) {
		String queueName = MessageUtils.generateQueueId(message.getToId());
		p2pMessageSender.send(queueName, message);
	}

	@Override
	public void sendNotification(Notification<?> message) {
		// TODO Auto-generated method stub

	}

	class GroupMembersCacheLoader extends
			CacheLoader<String, List<ChatGroupMember>> {
		ChatGroupMemberMapper chatGroupMemberMapper;

		public GroupMembersCacheLoader(
				ChatGroupMemberMapper chatGroupMemberMapper) {
			this.chatGroupMemberMapper = chatGroupMemberMapper;
		}

		@Override
		public List<ChatGroupMember> load(String key) throws Exception {
			key=key.substring(GROUP_CACHE_KEY_PREFIX.length());
			Long groupId=Long.valueOf(key); 
			return chatGroupMemberMapper.getGroupMembers(groupId);
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		GroupMembersCacheLoader cacheLoader = new GroupMembersCacheLoader(
				chatGroupMemberMapper);
		localGroupCache = CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(1, TimeUnit.MINUTES).build(cacheLoader);
	}

}
