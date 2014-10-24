/**
 * 
 */
package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ChatCategoryMapper;
import com.galaxy.dal.domain.chat.ChatCategory;

/**
 * @author luolishu
 *
 */
public class ChatCategoryMapperTest extends BaseDaoTest {
	@Autowired
	ChatCategoryMapper chatCategoryMapper;
	
	@Test
	public void test(){
		ChatCategory category=new ChatCategory();
		
		category.setCreatedTime(new Date());
		category.setParentId(33L);
		category.setPath("Hello");
		chatCategoryMapper.insert(category);
		
	}

}
