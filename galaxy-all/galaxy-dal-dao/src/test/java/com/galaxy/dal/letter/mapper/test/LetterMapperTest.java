/**
 * 
 */
package com.galaxy.dal.letter.mapper.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.domain.letter.Letter;
import com.galaxy.dal.letter.mapper.LetterMapper;

/**
 * @author luolishu
 *
 */
public class LetterMapperTest extends BaseDaoTest {
	@Resource
	LetterMapper letterMapper;

	@Test
	public void testInsert() {
		Letter letter=new Letter();
		letter.setToUserId(11L);
		letter.setFromUserId(22L);
		letter.setCreatedTime(new Date());
		letter.setContent("hello world!");
		letter.setIp("127.0.0.1");
		letter.setReadFlag(true);
		letter.setReply(true);
		letter.setStatus(1);
		letterMapper.insert(letter);

	}
	
	@Test
	public void testGetToUser() {
		List<Letter> letters=letterMapper.getToUserLetters(11L, 10);
		Assert.assertNotNull(letters);
		System.out.println(letters);

	}
	
	@Test
	public void testGetById() { 
		Letter letter=letterMapper.getById(1L);
		Assert.assertNotNull(letter);

	}

}
