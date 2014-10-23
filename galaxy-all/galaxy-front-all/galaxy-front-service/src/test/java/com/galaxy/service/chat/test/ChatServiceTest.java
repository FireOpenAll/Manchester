package com.galaxy.service.chat.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.service.chat.ChatService;
import com.galaxy.service.test.BaseServiceTest;

public class ChatServiceTest extends BaseServiceTest{
	@Autowired
	ChatService chatService;
    @Test
	public void test(){
    	Long groupId=chatService.createGroup("test", 1L, 2L);
    	Assert.assertNotNull(groupId);
    }
}
