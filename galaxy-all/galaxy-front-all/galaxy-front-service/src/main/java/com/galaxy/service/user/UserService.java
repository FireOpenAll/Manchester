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
	
	//设置邮箱为认证
	int setUserEmailAuthByEmail(Map<String, Object> map);
	
	User getUserbyEmailPassword(Map<String, String> map);
	User getUserbyMobilePassword(Map<String, String> map);
	User getUserbyLoginNamePassword(Map<String, String> map);
	
	//邮箱是否认证
	boolean checkEmailAuth(String email);

}
