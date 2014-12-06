package com.galaxy.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.user.UserProfile;
import com.galaxy.dal.user.mapper.UserProfileMapper;
import com.galaxy.service.user.UserProfileService;

/*author:huangshanqi
 *time  :2014年12月6日 上午11:00:35
 *email :hsqmobile@gmail.com
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileMapper userProfileMapper;public UserProfileServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean insert(UserProfile userProfile) {
		// TODO Auto-generated method stub
		UserProfile temp = userProfileMapper.getByUserIdProperty(userProfile.getId(), userProfile.getProperty());
		if (temp != null) {
			return false;
		}
		return userProfileMapper.insert(userProfile);
	}

	@Override
	public boolean update(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return userProfileMapper.update(userProfile);
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return deleteById(id);
	}

	@Override
	public UserProfile getById(Long id) {
		// TODO Auto-generated method stub
		return getById(id);
	}

	@Override
	public UserProfile getByUserIdProperty(Long id, String property) {
		// TODO Auto-generated method stub
		return userProfileMapper.getByUserIdProperty(id, property);
	}

	@Override
	public List<UserProfile> getAllUserProperty(Long id) {
		// TODO Auto-generated method stub
		return userProfileMapper.getAllUserProperty(id);
	}

}
