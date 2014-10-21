package com.galaxy.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.user.UserProfiles;

/*author:huangshanqi
 *time  :2014年10月19日 下午1:23:19
 *email :hsqmobile@gmail.com
 */
public interface UserProfileService {
	
	//插入属性
	public boolean insert(UserProfiles userProfiles);

	//得到用户的name 属性数据
	public UserProfiles getByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
	//删除用户的name 属性数据
	public UserProfiles deleteByUserIdName(@Param("user_id") Long user_id,@Param("name") String name);
		
	//得到用户id的所有属性
	public List<UserProfiles> getAllByUserId(@Param("user_id") Long user_id);
	//
}
