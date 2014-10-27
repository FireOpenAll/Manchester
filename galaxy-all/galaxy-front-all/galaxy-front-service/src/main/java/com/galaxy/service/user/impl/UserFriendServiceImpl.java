package com.galaxy.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.user.User;
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
	//update
	public boolean update(UserFriend userFriend){
		return userFriendMapper.update(userFriend);
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
	public List<UserFriend> getFollowingsByOffset(Long user_id,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (pageSize <=0 || pageSize >=100) {
			pageSize = 10;
		}
		if (pageNum <= 0) {
			pageNum = 1;
		}
		PaginationParam paginationParam = new PaginationParam();
		paginationParam.setSize(pageSize);
		paginationParam.setOffset((pageNum-1)*pageSize);
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("user_id", user_id);
		paginationParam.setPageData(map);
		List<UserFriend> relations = userFriendMapper.getFollowingsByOffset(paginationParam);
		
		return relations;
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
	public List<UserFriend> getFollowedsByOffset(Long user_id,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		if (pageSize <=0 || pageSize >=100) {
			pageSize = 10;
		}
		if (pageNum <= 0) {
			pageNum = 1;
		}
		PaginationParam paginationParam = new PaginationParam();
		paginationParam.setSize(pageSize);
		paginationParam.setOffset((pageNum-1)*pageSize);
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("user_id", user_id);
		paginationParam.setPageData(map);
		List<UserFriend> relations = userFriendMapper.getFollowedsByOffset(paginationParam);
		
		
		return relations;
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
	public List<UserFriend> getMutualUsersByOffset(Long user_id,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		if (pageSize <=0 || pageSize >=100) {
			pageSize = 10;
		}
		if (pageNum <= 0) {
			pageNum = 1;
		}
		PaginationParam paginationParam = new PaginationParam();
		paginationParam.setSize(pageSize);
		paginationParam.setOffset((pageNum-1)*pageSize);
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("user_id", user_id);
		paginationParam.setPageData(map);
		List<UserFriend> relations = userFriendMapper.getMutualUsersByOffset(paginationParam);
		
		
		return relations;
	}

	/**
	 * 得到全部我的互粉数
	 */
	@Override
	public int getMutualUsersNum(Long user_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.getMutualUsersNum(user_id);
	}

	@Override
	public List<UserFriend> getFollowingsByUntilId(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserFriend> getFollowedsByUntilId(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserFriend> getMutualUsersByUntilId(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
