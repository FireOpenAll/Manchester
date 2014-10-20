package com.galaxy.dal.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserProfiles;

public interface UserProfilesMapper extends BaseMapper<UserProfiles> {

	//得到用户的name 属性数据
	public UserProfiles getByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
	//删除用户的name 属性数据
	public UserProfiles deleteByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
		
	//得到用户id的所有属性
	public List<UserProfiles> getAllByUserId(@Param("user_id") Long user_id);
	//

}
