package com.galaxy.dal.user.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.User;

public interface UserMapper extends BaseMapper<User> {

	public boolean updateLoginInfo(Long id, Date visitTime);

	/**
	 * 查找有这email的用户数
	 */
	int countUsersByEmail(@Param("email") String email);

	/**
	 * 查找有这email的用户数
	 * 
	 * @param email
	 * @return
	 */
	int countUsersByMobile(@Param("mobile") String mobile);

	/**
	 * 查找有这email的用户数
	 */
	int countUsersByLoginName(@Param("login_name") String login_name);

	// 通过邮箱验证
	int setUserEmailAuthByEmail(Map<String, Object> map);

	int countEmailAuthed(@Param("email") String email);

	// 邮箱密码登陆
	User getUserbyEmailPassword(Map<String, String> map);

	User getUserbyMobilePassword(Map<String, String> map);

	User getUserbyLoginNamePassword(Map<String, String> map);
	
	public User findUserByLoginName(@Param("loginName")String loginName);
}