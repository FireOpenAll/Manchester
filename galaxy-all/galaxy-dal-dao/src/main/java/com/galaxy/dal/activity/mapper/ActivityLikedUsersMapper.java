package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityLikedUsers;

public interface ActivityLikedUsersMapper extends BaseMapper<ActivityLikedUsers> {
	
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsers(@Param("activity_id") Long activity_id);
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsersByActId(PaginationParam paginationParam);
	//分页得到用户点赞过的活动
	public List<ActivityLikedUsers> getUserLikedActByUntilId(@Param("userId") long userId,@Param("untilId") long untilId,@Param("pageSize") long pageSize);
	
	//计算user_id Liked过的活动数
	public int getLikedActNumByUserId(@Param("user_id")Long user_id);
	//取消点赞 
	public boolean cancelLiked(@Param("user_id") Long user_id,@Param("activity_id") Long activity_id);

	//getByUserIdActId
	public ActivityLikedUsers getByUserIdActId(@Param("user_id") Long user_id,@Param("activity_id") Long activity_id);
}
