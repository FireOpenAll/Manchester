package com.galaxy.dal.usergroup.mapper.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.usergroup.GroupApply;
import com.galaxy.dal.usergroup.mapper.GroupApplyMapper;

public class GroupApplyMapperTest extends BaseDaoTest {
	@Resource
	GroupApplyMapper groupApplyMapper;

	@Test
	public void testInsert() {
		GroupApply apply=new GroupApply();
		apply.setUserId(11L);
		apply.setGroupId(22L);
		groupApplyMapper.insert(apply);

	}
	
	@Test
	public void testGetById() { 
		GroupApply apply=groupApplyMapper.getById(1L);
		Assert.assertNotNull(apply);

	}

}
