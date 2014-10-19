package com.galaxy.service.user.impl;

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

	public User getUser(Long userId) { 
		return userMapper.getById(userId);
	}
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
	public int countUsersByEmail(String email) { 
		return userMapper.countUsersByEmail(email);
	}

	@Override
	public int countUsersByMobile(String mobile) { 
		return userMapper.countUsersByMobile(mobile);
	}

	@Override
	public int countUsersByLoginName(String login_name) { 
		return userMapper.countUsersByLoginName(login_name);
	}

	@Override
	public int setUserEmailAuthByEmail(Map<String, Object> map) { 
		return userMapper.setUserEmailAuthByEmail(map);
	}

	@Override
	public User getUserbyEmailPassword(Map<String, String> map) { 
		return userMapper.getUserbyEmailPassword(map);
	}

	@Override
	public boolean checkEmailAuth(String email) { 
		return (userMapper.countEmailAuthed(email)==1)?true:false;
	}

	@Override
	public User getUserbyMobilePassword(Map<String, String> map) { 
		return userMapper.getUserbyMobilePassword(map);
	}

	@Override
	public User getUserbyLoginNamePassword(Map<String, String> map) { 
		return userMapper.getUserbyLoginNamePassword(map);
	}

	@Override
	public User findUserByLoginName(String loginName) { 
		return userMapper.findUserByLoginName(loginName);
	}
	
	
	
	
	
	
	
	

}
