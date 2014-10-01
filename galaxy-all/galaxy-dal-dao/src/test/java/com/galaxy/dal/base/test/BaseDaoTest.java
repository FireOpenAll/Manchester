package com.galaxy.dal.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/spring/dao.xml",
		"/spring/datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseDaoTest {

}
