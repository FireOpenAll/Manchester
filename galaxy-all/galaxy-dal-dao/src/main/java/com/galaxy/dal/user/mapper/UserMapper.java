package com.galaxy.dal.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.User;

public interface UserMapper extends BaseMapper<User>{
	
	
	User getUser(@Param("userId") String userId);
}