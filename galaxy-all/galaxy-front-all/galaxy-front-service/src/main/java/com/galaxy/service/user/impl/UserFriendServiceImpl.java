package com.galaxy.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.dal.domain.user.UserFriendApply;
import com.galaxy.dal.user.mapper.UserFriendApplyMapper;
import com.galaxy.dal.user.mapper.UserFriendMapper;
import com.galaxy.service.user.UserFriendService;

/*author:huangshanqi
 *time  :2014年12月13日 下午2:21:38
 *email :hsqmobile@gmail.com
 */
@Service
public class UserFriendServiceImpl implements UserFriendService {

	@Autowired
	private UserFriendMapper userFriendMapper;
	@Autowired
	private UserFriendApplyMapper userFriendApplyMapper;
	@Override
	public boolean createUserFriend(UserFriend userFriend) {
		// TODO Auto-generated method stub
		UserFriend temp = userFriendMapper.getUserFriend(userFriend.getUserId(), userFriend.getTargetId());
		if(temp != null)
			return false;
		return userFriendMapper.insert(userFriend);
	}
	@Override
	public boolean deleteUserFriend(Long userFriendId) {
		// TODO Auto-generated method stub
		return userFriendMapper.deleteById(userFriendId);
	}
	
	
	
	
	
	@Override
	public boolean deleteUserFriendByUseridTargetid(Long userId, Long targetId) {
		// TODO Auto-generated method stub
		return userFriendMapper.deleteUserFriendByUseridTargetid(userId, targetId);
	}
	@Override
	public boolean hasAddFriend(Long userId, Long targetId) {
		// TODO Auto-generated method stub
		UserFriend temp = userFriendMapper.getUserFriend(userId, targetId);
		return temp != null;
	}
	@Override
	public UserFriend getUserFriendByUidTid(Long userId, Long targetId) {
		// TODO Auto-generated method stub
		return userFriendMapper.getUserFriend(userId,targetId);
	}
	@Override
	public List<UserFriend> getAllUserFriend(Long userId) {
		// TODO Auto-generated method stub
		return userFriendMapper.getAllfriend(userId);
	}
	@Override
	public boolean createUserFriendApply(UserFriendApply userFriendApply) {
		// TODO Auto-generated method stub
		UserFriendApply temp = userFriendApplyMapper.getuserFriendApply(userFriendApply.getUserId(), userFriendApply.getTargetId());
        if(temp != null)
        	return false;
		return userFriendApplyMapper.insert(userFriendApply);
	}
	@Override
	public boolean deleteUserFriendApply(Long userFriendApplyId) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.deleteById(userFriendApplyId);
	}
	@Override
	public boolean modifyUserFriendApply(UserFriendApply userFriendApply) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.update(userFriendApply);
	}
	@Override
	public UserFriendApply getUserFriendApplyByUidTid(Long userId, Long targetId) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.getuserFriendApply(userId, targetId);
	}
	@Override
	public List<UserFriendApply> getAllUserFriendApply(Long userId) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.getAllfriendApply(userId);
	}
	
	
	
	
}
