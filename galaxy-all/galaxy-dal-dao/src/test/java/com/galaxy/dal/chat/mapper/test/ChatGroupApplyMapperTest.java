package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatGroupApplyMapper;
import com.galaxy.dal.domain.chat.ChatGroupApply;

public class ChatGroupApplyMapperTest extends BaseDaoTest {
	@Autowired 
	ChatGroupApplyMapper chatGroupApplyMapper;

	@Test
	public void testInsert(){
		ChatGroupApply apply=new ChatGroupApply();
		apply.setApplyReason("hello world!");
		apply.setCreatedTime(new Date());
		apply.setGroupId(22L);
		apply.setManagerUserId(555L);
		apply.setName("name");
		apply.setUserId(33L);
		chatGroupApplyMapper.insert(apply);
	}
}
