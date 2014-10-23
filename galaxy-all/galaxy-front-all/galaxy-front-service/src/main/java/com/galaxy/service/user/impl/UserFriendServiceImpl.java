package com.galaxy.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.dal.user.mapper.UserFriendMapper;
import com.galaxy.service.user.UserFriendService;

/*author:huangshanqi
 *time  :2014年10月22日 上午11:08:41
 *email :hsqmobile@gmail.com
 */
@Service
public class UserFriendServiceImpl implements UserFriendService {
	
	@Autowired
	private UserFriendMapper userFriendMapper;

	 //insert
	@Override
	public boolean insert(UserFriend userFriend) {
		// TODO Auto-generated method stub
		return userFriendMapper.insert(userFriend);
	}

	//deleteById
	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return userFriendMapper.deleteById(id);
	}

	//getById
	@Override
	public UserFriend getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询两用户的关系
	 */
	@Override
	public UserFriend getUsersFriend(Long user_id, Long target_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getUsersFriend(user_id, target_id);
	}

    ////关注
	/**
	 * 得到我关注的全部用户
	 */
	@Override
	public List<UserFriend> getFollowings(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFollowings(user_id);
	}

	/**
	 * 分页得到我关注的用户
	 */
	@Override
	public List<UserFriend> getFollowingsByPage(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFollowingsByPage(paginationParam);
	}

	/**
	 * 得到我关注的用户数
	 */
	@Override
	public int getFollowingsNum(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFollowingsNum(user_id);
	}

    ////被关注
	/**
	 * 得到我的全部粉丝
	 */
	@Override
	public List<UserFriend> getFolloweds(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFolloweds(user_id);
	}

	/**
	 * 分页得到我的粉丝
	 */
	@Override
	public List<UserFriend> getFollowedsByPage(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFollowedsByPage(paginationParam);
	}

	/**
	 * 得到我的全部粉丝数
	 */
	@Override
	public int getFollowedsNum(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getFollowedsNum(user_id);
	}

     ////互粉
	/**
	 * 得到全部我的互粉用户
	 */
	@Override
	public List<UserFriend> getMutualUsers(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getMutualUsers(user_id);
	}

	/**
	 * 分页得到我的互粉用户
	 */
	@Override
	public List<UserFriend> getMutualUsersByPage(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return userFriendMapper.getMutualUsersByPage(paginationParam);
	}

	/**
	 * 得到全部我的互粉数
	 */
	@Override
	public int getMutualUsersNum(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getMutualUsersNum(user_id);
	}
	
	
	


}
