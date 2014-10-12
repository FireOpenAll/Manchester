package com.galaxy.kaptcha.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.code.kaptcha.Producer;

@ContextConfiguration(locations = { "/spring/kaptcha-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class KaptchaTest {
	@Autowired
	private Producer captchaProducer;

	@Test
	public void test(){
		Assert.assertNotNull(captchaProducer);
	}

}
