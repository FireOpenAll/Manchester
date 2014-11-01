package com.galaxy.service.user.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.domain.user.User;
import com.galaxy.service.test.BaseServiceTest;
import com.galaxy.service.user.UserService;

public class UserServiceTest extends BaseServiceTest{
	@Autowired
	UserService userService;
	
	@Test
	public void testFind(){
		User user=userService.findUserByLoginName("testtest");
		Assert.assertNotNull(user);
	}

}
