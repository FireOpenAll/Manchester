/**
 * 
 */
package com.galaxy.dal.user.mapper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;

/**
 * @author luolishu
 * 
 */
@ContextConfiguration(locations = { "/spring/dao.xml",
		"/spring/datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserMapper {
	@Autowired
	UserMapper userMapper;

	@Test
	public void testInsert() {
		User user = new User();
		user.setLoginName("hello");
		userMapper.insert(user);

	}

}
