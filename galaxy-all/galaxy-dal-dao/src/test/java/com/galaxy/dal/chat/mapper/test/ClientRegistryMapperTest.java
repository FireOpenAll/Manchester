package com.galaxy.dal.chat.mapper.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.galaxy.dal.base.test.BaseDaoTest;
import com.galaxy.dal.chat.mapper.ClientRegistryMapper;
import com.galaxy.dal.domain.chat.ClientRegistry;
import com.galaxy.dal.domain.chat.ClientRegistry.ClientType;

public class ClientRegistryMapperTest extends BaseDaoTest {
	@Autowired
	ClientRegistryMapper clientRegistryMapper;
	@Test
	public void testInsert(){
		ClientRegistry registry=new ClientRegistry();
		registry.setClientType(ClientType.ANDRIOD);
		registry.setCreatedTime(new Date());
		registry.setDeviceId("fdasfa");
		registry.setToken("token...");
		registry.setUserId(3232L);
		
		clientRegistryMapper.insert(registry);
	}

}
