package com.galaxy.dal.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserFriend;


public interface UserFriendMapper extends BaseMapper<UserFriend> {

	public UserFriend getUserFriend(@Param("userId") Long userId,@Param("targetId") Long targetId);
    public List<UserFriend> getAllfriend(@Param("userId") Long userId);
    public boolean deleteUserFriendByUseridTargetid(@Param("userId") Long userId,@Param("targetId") Long targetId);

}