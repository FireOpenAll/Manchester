package com.galaxy.dal.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.galaxy.dal.domain.user.User;

public interface UserMapper {
	@Select("SELECT * FROM users WHERE id = #{userId}")
	User getUser(@Param("userId") String userId);
}