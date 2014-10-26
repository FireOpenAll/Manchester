/**
 * 
 */
package com.galaxy.dal.activity.mapper.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.activity.mapper.ActivityJoinedUsersMapper;
import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;

/**
 * @author luolishu
 *
 */
public class ActivityJoinedUsersMapperTest extends BaseDaoTest {
	@Resource
	ActivityJoinedUsersMapper activityJoinedUsersMapper;

	@Test
	public void testInsert() {
		ActivityJoinedUsers joinedUser = new ActivityJoinedUsers(); 
		joinedUser.setActivityId(11L);
		joinedUser.setCreatedTime(new Date());
		joinedUser.setTicketNum(10);
		joinedUser.setUserId(11L);
		joinedUser.setUserName("中午放大说");
		activityJoinedUsersMapper.insert(joinedUser);

	}

	@Test
	public void testGetById() {
		ActivityJoinedUsers joinedUser = activityJoinedUsersMapper.getById(1L);
		Assert.assertNotNull(joinedUser);
		System.out.println(joinedUser);

	}
}
