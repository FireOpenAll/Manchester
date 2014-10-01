package com.galaxy.dal.user.mapper;

import java.util.Date;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.User;

public interface UserMapper extends BaseMapper<User>{
	
	public boolean updateLoginInfo(Long id,Date visitTime);
	
	 
}