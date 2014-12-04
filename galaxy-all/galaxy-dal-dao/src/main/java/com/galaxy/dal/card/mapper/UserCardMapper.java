package com.galaxy.dal.card.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.card.UserCard;

/*author:huangshanqi
 *time  :2014年12月4日 下午1:15:56
 *email :hsqmobile@gmail.com
 */
public interface UserCardMapper extends BaseMapper<UserCard> {
	
	public UserCard getByUserIdTargetUserId(@Param("userId") Long userId,@Param("targetUserId") Long targetUserId);
	public List<UserCard> getAllFriendCard(@Param("userId") Long userId);
	public List<UserCard> getFriendCardPageByOffset(@Param("userId") Long userId,@Param("offset")int offset,@Param("pageSize") int pageSize);

}
