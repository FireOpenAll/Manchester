package com.galaxy.service.user;


import java.util.Date;

import com.galaxy.dal.domain.user.User;

public interface UserService {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	public boolean createUser(User user);
	public boolean update(User user);
	public User getUserById(Long userId);
    public boolean deleteById(Long userId);
    
	public boolean updateLoginInfo(Long id,Date LastVisitTime);
	
	public User getUserByEmail(String email);
	public User getUserByLoginName( String loginName);
	public User getUserByMobile(String mobile);
    public User getUserByEmailPassword(String email,String password);
    public User getUserByLoginNamePassword(String loginName,String password);
    public User getUserByMobilePassword(String mobile,String password);
	
	////update
	public boolean updateUserFriendNumByUserId(Long userId,int num);
	public boolean updateEmailAuthByEmail(String email,Boolean emailAuth);
	public boolean updateMobileAuthByMobile(String mobile,Boolean mobileAuth);
	////update

	public User findUserByLoginName(String loginName);
	
	public boolean isEmailExisted(String email);
	public boolean isLoginNameExisted(String loginName);
	public boolean isMobileExisted(String mobile);
	

}
