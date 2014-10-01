package com.galaxy.dal.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserProfiles;

public interface UserProfilesMapper extends BaseMapper<UserProfiles> {

	public UserProfiles getProfiles(@Param("userId") Long userId,
			@Param("name") String name);

}
