package com.galaxy.service.user.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.commons.utils.Digests;
import com.galaxy.commons.utils.Encodes;
import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	@Override
	public boolean createUser(User user) { 
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
		return userMapper.insert(user);
	}
	
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}
	
	public User getUserById(Long userId) { 
		return userMapper.getById(userId);
	}
	
	public boolean deleteById(Long userId){
		return userMapper.deleteById(userId);
	}

	@Override
	public boolean updateLoginInfo(Long id, Date lastVisitTime) {
		// TODO Auto-generated method stub
		return userMapper.updateLoginInfo(id, lastVisitTime);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.getUserByEmail(email);
	}

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginName(loginName);
	}

	@Override
	public User getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return userMapper.getUserByMobile(mobile);
	}

	@Override
	public User getUserByEmailPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByEmailPassword(email, password);
	}

	@Override
	public User getUserByLoginNamePassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginNamePassword(loginName, password);
	}

	@Override
	public User getUserByMobilePassword(String mobile, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByMobilePassword(mobile, password);
	}

	@Override
	public boolean updateUserFriendNumByUserId(Long userId, int num) {
		// TODO Auto-generated method stub
		return userMapper.updateUserFriendNumByUserId(userId, num)>0;
	}

	@Override
	public boolean updateEmailAuthByEmail(String email, Boolean emailAuth) {
		// TODO Auto-generated method stub
		return userMapper.updateEmailAuthByEmail(email,emailAuth)>0;
	}

	@Override
	public boolean updateMobileAuthByMobile(String mobile, Boolean mobileAuth) {
		// TODO Auto-generated method stub
		return userMapper.updateMobileAuthByMobile(mobile, mobileAuth)>0;
	}

	@Override
	public User findUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginName(loginName);
	}

	@Override
	public boolean isEmailExisted(String email) {
		// TODO Auto-generated method stub
		return userMapper.getUserByEmail(email) != null;
	}

	@Override
	public boolean isLoginNameExisted(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginName(loginName) != null;
	}

	@Override
	public boolean isMobileExisted(String mobile) {
		// TODO Auto-generated method stub
		return userMapper.getUserByMobile(mobile) != null;
	}	
	
	
	

}
