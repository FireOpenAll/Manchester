package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatGroupMemberMapper;
import com.galaxy.dal.domain.DBStatus;
import com.galaxy.dal.domain.chat.ChatGroupMember;
import com.galaxy.dal.domain.chat.ChatGroupRole;

public class ChatGroupMemberMapperTest extends BaseDaoTest {
	@Autowired
	ChatGroupMemberMapper chatGroupMemberMapper;

	@Test
	public void testInsert(){
		ChatGroupMember member=new ChatGroupMember();
		member.setCreatedTime(new Date());
		member.setDescription("fdafasdjlf");
		member.setEmail("fdasfasfdas");
		member.setGroupId(32432L);
		member.setPhone("42349821");
		member.setRole(ChatGroupRole.MEMBER);
		member.setStatus(DBStatus.INIT);
		member.setUserId(342L);
		member.setUserName("fdaslfj");
		
		chatGroupMemberMapper.insert(member);
	}
}
