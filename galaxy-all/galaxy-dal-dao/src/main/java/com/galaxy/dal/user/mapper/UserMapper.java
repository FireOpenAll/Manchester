package com.galaxy.dal.user.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.User;

public interface UserMapper extends BaseMapper<User> {

	public boolean updateLoginInfo(@Param("id")Long id, @Param("LastVisitTime")Date LastVisitTime);
	
	public User getUserByEmail(@Param("email") String email);
	public User getUserByLoginName(@Param("loginName") String loginName);
	public User getUserByMobile(@Param("mobile") String mobile);
    public User getUserByEmailPassword(@Param("email") String email,@Param("password") String password);
    public User getUserByLoginNamePassword(@Param("loginName") String loginName,@Param("password") String password);
    public User getUserByMobilePassword(@Param("mobile") String mobile,@Param("password") String password);
	
	////update
	int updateUserFriendNumByUserId(@Param("userId")Long userId,@Param("num")int num);
	int updateEmailAuthByEmail(@Param("email") String email,@Param("emailAuth") Boolean emailAuth);
	int updateMobileAuthByMobile(@Param("mobile") String mobile,@Param("mobileAuth") Boolean mobileAuth);
	////update

	public User findUserByLoginName(@Param("loginName")String loginName);
}