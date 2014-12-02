/**
 * 
 */
package com.galaxy.dal.user.mapper.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.user.UserProfile;
import com.galaxy.dal.user.mapper.UserProfilesMapper;

/**
 * @author luolishu
 * 
 */
public class TestUserProfilesMapper extends BaseDaoTest {
	@Autowired
	UserProfilesMapper userProfilesMapper;

	@Test
	public void testInsert() {
		UserProfile profile = new UserProfile();
		profile.setCreatedTime(new Date());
		profile.setUserId(11L);
		profile.setName("key1");
		profile.setValue("东直门");
		userProfilesMapper.insert(profile);

	}

	@Test
	public void testGetById() {
		UserProfile profile = userProfilesMapper.getById(1L);
		Assert.assertNotNull(profile);
		System.out.println(profile);

	}
}
