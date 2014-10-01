/**
 * 
 */
package com.galaxy.dal.user.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;

/**
 * @author luolishu
 * 
 */ 
public class TestUserMapper extends BaseDaoTest  {
	@Autowired
	UserMapper userMapper;

	@Test
	public void testInsert() {
		User user = new User();
		user.setLoginName("hello");
		user.setBirthday(new Date());
		user.setEmail("testests@test.com");
		user.setFans(100);
		user.setFollowers(200);
		user.setHasPic(true);
		user.setEmailAuth(true);
		user.setWebchatOpenid("webchat");
		userMapper.insert(user);

	}

}
