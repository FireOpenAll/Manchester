package com.galaxy.dal.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserProfile;

public interface UserProfilesMapper extends BaseMapper<UserProfile> {

	//得到用户的name 属性数据
	public UserProfile getByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
	//删除用户的name 属性数据
	public UserProfile deleteByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
		
	//得到用户id的所有属性
	public List<UserProfile> getAllByUserId(@Param("user_id") Long user_id);
	//

}
