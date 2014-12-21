package com.galaxy.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.dal.domain.user.UserFriendApply;
import com.galaxy.dal.user.mapper.UserFriendApplyMapper;
import com.galaxy.dal.user.mapper.UserFriendMapper;
import com.galaxy.dal.user.mapper.UserMapper;
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
	@Autowired
	private UserMapper userMapper;
	
	
	@Transactional
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
	
	
	
	
	
	@Transactional
	@Override
	public boolean deleteUserFriendByUseridTargetid(Long userId, Long targetId) {
		// TODO Auto-generated method stub
	  UserFriendApply apply = userFriendApplyMapper.getuserFriendApply(targetId, userId);
	  if(apply != null){
		  apply.setApplyStatus(0);
		  userFriendApplyMapper.update(apply);
	  }
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
	}public UserFriendServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public List<User> getAllUserFriend(Long userId) {
		// TODO Auto-generated method stub
		List<UserFriend> list = userFriendMapper.getAllfriend(userId);
		if(list == null){
			return null;
		}
		List<User> result = new ArrayList<User>();
		for(UserFriend userFriend:list){
			User user = userMapper.getById(userFriend.getTargetId());
			if(user != null){
				result.add(user);
			}
		}
		return result;
	}
	
	
	
	
	@Transactional
	@Override
	public boolean acceptFriendApply(UserFriend userFriend) {
		// TODO Auto-generated method stub
		UserFriendApply  apply = userFriendApplyMapper.getuserFriendApply(userFriend.getTargetId(), userFriend.getUserId());
		if(apply == null){
			return false;
		}
		if(!hasAddFriend(userFriend.getUserId(),userFriend.getTargetId())){
		    userFriendMapper.insert(userFriend);
		}
		if(!hasAddFriend(userFriend.getTargetId(),userFriend.getUserId())){
			Long tempId = userFriend.getUserId();
			userFriend.setUserId(userFriend.getTargetId());
			userFriend.setTargetId(tempId);
		    userFriendMapper.insert(userFriend);
		}
		apply.setUpdatedTime(new Date());
		apply.setApplyStatus(1);
		return userFriendApplyMapper.update(apply);
	}
	@Override
	public UserFriendApply getUserFriendApplyByid(Long applyId) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.getById(applyId);
	}
	@Transactional
	@Override
	public boolean createUserFriendApply(UserFriendApply userFriendApply) {
		// TODO Auto-generated method stub
		UserFriendApply temp = userFriendApplyMapper.getuserFriendApply(userFriendApply.getUserId(), userFriendApply.getTargetId());
        if(temp == null)
        	return userFriendApplyMapper.insert(userFriendApply);
		if(temp.getApplyStatus() == 1){
			return false;
		}else{
			temp.setUpdatedTime(userFriendApply.getCreatedTime());
			temp.setMessage(userFriendApply.getMessage());
			temp.setApplyStatus(userFriendApply.getApplyStatus());
			return userFriendApplyMapper.update(temp);
		}
	}
	@Override
	public boolean deleteUserFriendApply(Long userFriendApplyId) {
		// TODO Auto-generated method stub
		return userFriendApplyMapper.deleteById(userFriendApplyId);
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
