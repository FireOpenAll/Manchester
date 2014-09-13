package com.galaxy.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getUser(userId);
	}

}
