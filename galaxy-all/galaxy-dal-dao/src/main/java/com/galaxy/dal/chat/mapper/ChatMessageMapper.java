package com.galaxy.dal.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.PaginationParam;
import com.galaxy.dal.domain.chat.ChatMessage;

public interface ChatMessageMapper extends BaseMapper<ChatMessage> {
	List<ChatMessage> listMessage(@Param("userId")Long userId,@Param("toId") Long toId,
			@Param("page")PaginationParam pageParam);

	List<ChatMessage> listGroupMessage(@Param("userId")Long userId,@Param("groupId")Long groupId, @Param("page")PaginationParam pageParam);
}
