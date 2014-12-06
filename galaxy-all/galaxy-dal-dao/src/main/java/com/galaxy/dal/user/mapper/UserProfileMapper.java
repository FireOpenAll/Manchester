package com.galaxy.dal.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserProfile;
import com.galaxy.dal.domain.user.UserprofileKey;

/*author:huangshanqi
 *time  :2014年12月6日 上午10:38:38
 *email :hsqmobile@gmail.com
 */
public interface UserProfileMapper extends BaseMapper<UserProfile> {

	public UserProfile getByUserIdProperty(@Param("id") Long id,@Param("property") String property);
	public List<UserProfile> getAllUserProperty(@Param("id") Long id);
}
