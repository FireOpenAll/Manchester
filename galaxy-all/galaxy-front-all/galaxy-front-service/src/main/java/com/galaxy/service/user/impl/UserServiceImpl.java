package com.galaxy.service.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return userMapper.getById(userId);
	}

	@Override
	public boolean createUser(User user) { 
		return userMapper.insert(user);
	}

	@Override
	public int countUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.countUsersByEmail(email);
	}

	@Override
	public int countUsersByMobile(String mobile) {
		// TODO Auto-generated method stub
		return userMapper.countUsersByMobile(mobile);
	}

	@Override
	public int countUsersByLoginName(String login_name) {
		// TODO Auto-generated method stub
		return userMapper.countUsersByLoginName(login_name);
	}

	@Override
	public int setUserEmailAuthByEmail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.setUserEmailAuthByEmail(map);
	}
	
	
	
	
	

}
