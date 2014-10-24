/**
 * 
 */
package com.galaxy.dal.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.chat.ChatGroupApply;

/**
 * @author luolishu
 *
 */
public interface ChatGroupApplyMapper extends BaseMapper<ChatGroupApply> {
	public List<ChatGroupApply> getApplyByUserId(@Param("userId")Long userId);
	
	public List<ChatGroupApply> getApplyByGroupAndUserId(@Param("groupId")Long groupId,@Param("userId")Long userId);

}
