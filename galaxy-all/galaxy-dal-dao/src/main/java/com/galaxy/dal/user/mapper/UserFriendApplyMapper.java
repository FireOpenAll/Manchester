package com.galaxy.dal.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.user.UserFriendApply;


public interface UserFriendApplyMapper extends BaseMapper<UserFriendApply> {

	public UserFriendApply getuserFriendApply(@Param("userId") Long userId,@Param("targetId") Long targetId);
    public List<UserFriendApply> getAllfriendApply(@Param("userId") Long userId);

}