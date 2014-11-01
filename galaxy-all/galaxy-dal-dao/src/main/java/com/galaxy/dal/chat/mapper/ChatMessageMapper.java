package com.galaxy.dal.chat.mapper;

import java.util.List;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.PaginationParam;
import com.galaxy.dal.domain.chat.ChatMessage;

public interface ChatMessageMapper extends BaseMapper<ChatMessage> {
	List<ChatMessage> listMessage(Long fromId, Long toId,
			PaginationParam pageParam);

	List<ChatMessage> listGroupMessage(Long groupId, PaginationParam pageParam);
}
