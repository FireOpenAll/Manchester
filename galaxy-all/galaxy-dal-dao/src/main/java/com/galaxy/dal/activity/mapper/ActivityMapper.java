package com.galaxy.dal.activity.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.Activity;

public interface ActivityMapper extends BaseMapper<Activity>{

	//统计某user_id发布的活动数
	public int getUserCreatedActNum(@Param("user_id") Long user_id);
}
