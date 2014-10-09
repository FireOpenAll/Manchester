package com.galaxy.service.user;


import java.util.Map;

import com.galaxy.dal.domain.user.User;

public interface UserService {

	User getUser(Long userId);

	boolean createUser(User user);
	
	/**
	 * 查找有这email的用户数
	 * @param email
	 * @return
	 */
	int countUsersByEmail(String email);
	int countUsersByMobile(String mobile);
	int countUsersByLoginName(String login_name);
	
	int setUserEmailAuthByEmail(Map<String, Object> map);

}
