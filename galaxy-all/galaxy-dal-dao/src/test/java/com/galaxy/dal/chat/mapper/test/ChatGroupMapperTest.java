package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatGroupMapper;
import com.galaxy.dal.domain.chat.ChatGroup;

public class ChatGroupMapperTest extends BaseDaoTest {
	@Autowired
	ChatGroupMapper chatGroupMapper;
	@Test
	public void testInsert(){
		ChatGroup group=new ChatGroup();
		group.setActivityId(222L);
		group.setCateId1(22L);
		group.setCreatedTime(new Date());
		group.setMemberDesc("Hello world!");
		group.setName("fdasfad");
		group.setOwnerUserId(3322L);
		group.setPublicDesc("fdafads");
		group.setOwnerUserId(3232L);
		group.setPublicDesc("fdafad");
		chatGroupMapper.insert(group);
	}

}
