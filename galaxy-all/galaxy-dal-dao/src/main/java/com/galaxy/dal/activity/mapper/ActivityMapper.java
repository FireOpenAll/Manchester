package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.Activity;

public interface ActivityMapper extends BaseMapper<Activity>{

	//统计某user_id发布的活动数
	public int getUserCreatedActNum(@Param("user_id") Long user_id);
	//分页获取某人发布的活动 
	public List<Activity> getUserCreatedActByUntilId (@Param("user_id") long userId,@Param("until_id") long untilId,@Param("pageSize") int pageSize);
}