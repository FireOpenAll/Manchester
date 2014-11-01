package com.galaxy.message.service;

import java.util.List;

import com.galaxy.dal.domain.PaginationParam;
import com.lepeng.im.message.Message;

public interface ChatQueryService {
	
	List<Message<?>> listMessage(Long fromId,Long toId,PaginationParam pageParam);
	
	List<Message<?>> listGroupMessage(Long groupId,PaginationParam pageParam);

}
