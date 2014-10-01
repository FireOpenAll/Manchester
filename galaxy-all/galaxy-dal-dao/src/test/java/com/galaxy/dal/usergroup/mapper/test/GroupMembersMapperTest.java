package com.galaxy.dal.usergroup.mapper.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.usergroup.Group;
import com.galaxy.dal.domain.usergroup.GroupMembers;
import com.galaxy.dal.usergroup.mapper.GroupMembersMapper;

public class GroupMembersMapperTest extends BaseDaoTest {
	@Resource
	GroupMembersMapper groupMembersMapper;

	@Test
	public void testInsert() {
		GroupMembers member = new GroupMembers();
		member.setCreatedTime(new Date());
		member.setGroupId(11L);
		member.setUserId(22L);
		groupMembersMapper.insert(member);
	}

	@Test
	public void testGetById() { 
		GroupMembers member=groupMembersMapper.getById(1L);
		Assert.assertNotNull(member);

	}
}
