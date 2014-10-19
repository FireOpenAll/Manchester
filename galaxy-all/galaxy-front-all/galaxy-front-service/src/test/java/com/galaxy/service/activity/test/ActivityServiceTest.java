package com.galaxy.service.activity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.service.activity.ActivityService;

@ContextConfiguration(locations = { "/spring/dao.xml",
		"/spring/datasource-config.xml" ,"/spring/service.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityServiceTest {
	@Autowired
	ActivityService activityService;
	@Test
	public void testJoin(){
		activityService.joinActivity(1L, 1L);
	}
}
