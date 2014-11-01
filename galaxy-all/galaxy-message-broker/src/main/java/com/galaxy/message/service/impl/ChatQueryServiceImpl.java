package com.galaxy.message.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.chat.mapper.ChatMessageMapper;
import com.galaxy.dal.domain.PaginationParam;
import com.galaxy.dal.domain.chat.ChatMessage;
import com.galaxy.message.service.ChatQueryService;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.json.JsonDecoder;
@Service
public class ChatQueryServiceImpl implements ChatQueryService {
	@Autowired
	ChatMessageMapper chatMessageMapper;

	@Override
	public List<Message<?>> listMessage(Long userId,Long toId,
			PaginationParam pageParam) {
		List<ChatMessage> messageList=chatMessageMapper.listMessage(userId, toId, pageParam); 
		List<Message<?>> resultList=new LinkedList<Message<?>>();
		if(messageList!=null){
			for(ChatMessage msg:messageList){
				Message<?> message=JsonDecoder.decode(msg.getBody());
				resultList.add(message);
			}
		}
		return resultList;
	}

	@Override
	public List<Message<?>> listGroupMessage(Long userId,Long groupId,
			PaginationParam pageParam) {
		List<ChatMessage> messageList=chatMessageMapper.listGroupMessage(userId,groupId, pageParam); 
		List<Message<?>> resultList=new LinkedList<Message<?>>();
		if(messageList!=null){
			for(ChatMessage msg:messageList){
				Message<?> message=JsonDecoder.decode(msg.getBody());
				resultList.add(message);
			}
		}
		return resultList;
	}

}
