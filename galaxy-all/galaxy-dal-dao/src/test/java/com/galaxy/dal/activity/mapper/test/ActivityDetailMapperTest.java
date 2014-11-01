package com.galaxy.dal.activity.mapper.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.activity.ActivityDetail;

public class ActivityDetailMapperTest extends BaseDaoTest {
	@Resource
	ActivityDetailMapper activityDetailMapper;

	@Test
	public void testInsert() {
		ActivityDetail detail = new ActivityDetail();
		detail.setId(1L);
		detail.setContent("fdasfadsfajsdlfdasfasfjasdlkfjdaslkfjaldskfjadslkfjdlkasfjasdlk");
		detail.setCreatedTime(new Date());
		activityDetailMapper.insert(detail);

	}

	@Test
	public void testGetById() {
		ActivityDetail detail = activityDetailMapper.getById(1L);
		Assert.assertNotNull(detail);
		System.out.println(detail);

	}
}
