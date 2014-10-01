/**
 * 
 */
package com.galaxy.dal.usergroup.mapper.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.usergroup.Group;
import com.galaxy.dal.domain.usergroup.GroupType;
import com.galaxy.dal.usergroup.mapper.GroupMapper;

/**
 * @author luolishu
 * 
 */
public class GroupMapperTest extends BaseDaoTest {
	@Resource
	GroupMapper groupMapper;

	@Test
	public void testInsert() {
		Group group = new Group();
		group.setCreatedTime(new Date());
		group.setName("groupName");
		group.setDisplayType(1);
		group.setCreateUserId(11L);
		group.setDomain("www.qq.com");
		group.setName("fdasfdasfadsfas");
		group.setDescription("hello");
		group.setGroupType(GroupType.CLASSMATE);
		groupMapper.insert(group);

	}

	@Test
	public void testGetById() {
		Group group = groupMapper.getById(1L);
		Assert.assertNotNull(group);
		System.out.println(group);

	}

	@Test
	public void testList() {
		PaginationParam paginationParam = new PaginationParam();
		List<Group> groupList = groupMapper.list(paginationParam);
		Assert.assertNotNull(groupList);
		System.out.println(groupList);

	}
}
