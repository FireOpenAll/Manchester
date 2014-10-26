package com.galaxy.service.activity;

import java.util.List;
import java.util.Map;
 

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.service.activity.form.ActivityForm;

public interface ActivityService {

	public Long create(ActivityForm form);
	
	public boolean modify(ActivityForm form);

	public boolean removeById(Long id);

	

	public Activity getActivity(Long id);
	
	

	public List<Activity> list(Map parameters, int size);
	
	////join
	public boolean joinActivity(Long activityId, Long userId);
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId);
	
	public ActivityJoinedUsers getActivityJoinUserByUserId(Long activityId,Long userId);
	
	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,Long fromId,Long size);
	
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(Long user_id);

	////join
	
	
	////like
	public boolean likeActivity(ActivityLikedUsers activityLikedUsers);
	
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsers(Long activity_id);
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsersByActId(PaginationParam paginationParam);
	//计算user_id Liked过的活动数
	public int getLikedActNumByUserId(Long user_id);
	//取消点赞 
	public boolean cancelLiked(Long user_id,Long activity_id);

	
	////like
	
	////comment
	//统计user_id评论过的活动数
	public int getUserComActNum( Long user_id);
	////comment
	
	//统计某user_id发布的活动数
	public int getUserCreatedActNum(Long user_id);
}
