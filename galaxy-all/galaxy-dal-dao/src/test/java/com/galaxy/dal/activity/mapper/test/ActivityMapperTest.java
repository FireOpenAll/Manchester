package com.galaxy.dal.activity.mapper.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.activity.Activity;

public class ActivityMapperTest extends BaseDaoTest {
	@Resource
	ActivityMapper activityMapper;

	@Test
	public void testInsert() {
		Activity activity = new Activity(); 
		activity.setAddress("北京市朝阳区");
		activity.setCityId(1L);
		activity.setDistrictId(2L);
		activity.setCreatedTime(new Date());
		activityMapper.insert(activity);

	}

	@Test
	public void testGetById() {
		Activity activity = activityMapper.getById(1L);
		Assert.assertNotNull(activity);
		System.out.println(activity);

	}
}
