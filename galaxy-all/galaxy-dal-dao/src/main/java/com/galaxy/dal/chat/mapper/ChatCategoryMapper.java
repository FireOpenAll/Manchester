package com.galaxy.dal.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.chat.ChatCategory;

public interface ChatCategoryMapper extends BaseMapper<ChatCategory> {

	List<ChatCategory> getChilds(@Param("cateId")Long cateId);
	
	List<ChatCategory> getParents(@Param("cateId")Long cateId);

}
