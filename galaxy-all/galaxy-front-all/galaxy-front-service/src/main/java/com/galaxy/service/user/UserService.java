package com.galaxy.service.user;


import java.util.Map;

import com.galaxy.dal.domain.user.User;

public interface UserService {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	User getUser(Long userId);

	boolean createUser(User user);
	////update
	public boolean update(User user);
	public boolean updateUserFansNumById(Long userId,int num);
	
	public boolean updateUserFollowersNumById(Long userId,int num);
	////update
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
	
	User findUserByLoginName(String loginName);
	User getUserbyEmailPassword(Map<String, String> map);
	User getUserbyMobilePassword(Map<String, String> map);
	User getUserbyLoginNamePassword(Map<String, String> map);
	
	//邮箱是否认证
	boolean checkEmailAuth(String email);

}
