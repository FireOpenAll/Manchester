package com.galaxy.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.user.UserProfile;
import com.galaxy.dal.domain.user.UserprofileKey;

/*author:huangshanqi
 *time  :2014年10月19日 下午1:23:19
 *email :hsqmobile@gmail.com
 */
public interface UserProfileService {
	public boolean insert(UserProfile userProfile);

	public boolean update(UserProfile userProfile);

	public boolean deleteById(Long id);

	public UserProfile getById(Long id);
	
	public UserProfile getByUserIdProperty(Long id,String property);
	public List<UserProfile> getAllUserProperty( Long id);
}
