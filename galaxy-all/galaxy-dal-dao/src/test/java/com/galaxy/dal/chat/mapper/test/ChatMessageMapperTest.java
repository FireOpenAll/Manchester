package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatMessageMapper;
import com.galaxy.dal.domain.chat.ChatMessage;

public class ChatMessageMapperTest extends BaseDaoTest {
	@Autowired
	ChatMessageMapper chatMessageMapper;
	
	@Test
	public void testInsert(){
		ChatMessage message=new ChatMessage();
		message.setBody("body");
		message.setCreatedTime(new Date());
		message.setMessageType(3232L);
		message.setStatus(32);
		message.setUserId(3232L);
		
		chatMessageMapper.insert(message);
	}

}
