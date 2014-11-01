package com.galaxy.message.service;

import java.util.List;

import com.galaxy.dal.domain.PaginationParam;
import com.lepeng.im.message.Message;

public interface ChatQueryService {
	
	List<Message<?>> listMessage(Long userId,Long toId,PaginationParam pageParam);
	
	List<Message<?>> listGroupMessage(Long userId,Long groupId,PaginationParam pageParam);

}
