package com.galaxy.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.user.UserProfile;
import com.galaxy.dal.user.mapper.UserProfilesMapper;
import com.galaxy.service.user.UserProfileService;

/*author:huangshanqi
 *time  :2014年10月19日 下午1:24:24
 *email :hsqmobile@gmail.com
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfilesMapper userProfilesMapper;

	
	@Override
	public boolean insert(UserProfile userProfiles) {
		// TODO Auto-generated method stub
		return userProfilesMapper.insert(userProfiles);
	}

	@Override
	public UserProfile getByUserIdName(Long user_id, String name) {
		// TODO Auto-generated method stub
		return userProfilesMapper.getByUserIdName(user_id, name);
	}

	@Override
	public UserProfile deleteByUserIdName(Long user_id, String name) {
		// TODO Auto-generated method stub
		return userProfilesMapper.deleteByUserIdName(user_id, name);
	}

	@Override
	public List<UserProfile> getAllByUserId(Long user_id) {
		// TODO Auto-generated method stub
		return userProfilesMapper.getAllByUserId(user_id);
	}
	
	
}
