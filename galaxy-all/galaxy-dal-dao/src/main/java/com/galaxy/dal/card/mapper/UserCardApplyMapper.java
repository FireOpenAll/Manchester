package com.galaxy.dal.card.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.card.UserCardApply;

/*author:huangshanqi
 *time  :2014年12月17日 上午10:32:12
 *email :hsqmobile@gmail.com
 */
public interface UserCardApplyMapper extends BaseMapper<UserCardApply> {

	public UserCardApply getUserCardApply(@Param("userId") Long userId,@Param("targetId") Long targetId);
	public List<UserCardApply> getAllCardApply(@Param("userId") Long userId);
}
