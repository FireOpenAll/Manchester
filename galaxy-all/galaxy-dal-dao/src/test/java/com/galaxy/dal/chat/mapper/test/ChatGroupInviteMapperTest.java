package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatGroupInviteMapper;
import com.galaxy.dal.domain.chat.ChatGroupInvite;
import com.galaxy.dal.domain.chat.ChatGroupInvite.Status;

public class ChatGroupInviteMapperTest extends BaseDaoTest {
	@Autowired 
	ChatGroupInviteMapper chatGroupInviteMapper;
	
	@Test
	public void testInsert(){
		ChatGroupInvite invite=new ChatGroupInvite();
		invite.setCreatedTime(new Date());
		invite.setFromId(111L);
		invite.setGroupId(222L);
		invite.setMsg("fdasfasfa");
		invite.setUserId(333L);
		invite.setStatus(Status.CONFIRM);
		chatGroupInviteMapper.insert(invite);
	}

}
