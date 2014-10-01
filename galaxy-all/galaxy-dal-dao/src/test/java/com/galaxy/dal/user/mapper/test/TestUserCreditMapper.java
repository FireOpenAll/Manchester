package com.galaxy.dal.user.mapper.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.user.UserCredit;
import com.galaxy.dal.user.mapper.UserCreditMapper;

public class TestUserCreditMapper extends BaseDaoTest {
	@Autowired
	UserCreditMapper userCreditMapper;
	

	@Test
	public void testInsert() {
		UserCredit credit = new UserCredit();  
		userCreditMapper.insert(credit);

	}

	@Test
	public void testGetById() {
		UserCredit credit = userCreditMapper.getById(1L);
		Assert.assertNotNull(credit);
		System.out.println(credit);

	}
}
