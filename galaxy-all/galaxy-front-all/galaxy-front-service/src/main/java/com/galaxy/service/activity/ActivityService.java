package com.galaxy.service.activity;

import java.util.List;
import java.util.Map;
 




import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.dal.domain.user.User;
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
	
	//用户参加的所有活动
	public List<Activity> listAllJoinedActs(Long userId);
	
	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,Long fromId,int size);
	
	//列出某活动的前几个参加用户
	public List<User> listTopActJionUser(Long activityId,int size);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(Long user_id);
	
	//用户user_id是否已参加某活动activity_id]
	public boolean isUserJoinedActivity(Long userId,Long activityId);

	////join
	
	
	////like
	public boolean likeActivity(ActivityLikedUsers activityLikedUsers);
	
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsers(Long activity_id);
	//分页列出某个活动点赞的用户
	public List<ActivityLikedUsers> listAllLikedUsersByActId(PaginationParam paginationParam);
	//分页得到用户点赞过的活动
	public List<Activity> getUserLikedActByUntilId(long userId,long untilId,long pageSize);
	//计算user_id Liked过的活动数
	public int getLikedActNumByUserId(Long user_id);
	//取消点赞 
	public boolean cancelLiked(Long user_id,Long activity_id);
    //用户是否已点赞某活动
	public boolean isUserLikedActivity(Long UserId,Long activityId);
	
	////like
	
	////comment
	//统计user_id评论过的活动数
	public int getUserComActNum( Long user_id);
	//统计某个活动总的评论人数
	public int getCommUserNum(Long activityId);
	//分页得到某活动的评论
	public List<ActivityComment> getActComByUntilId(Long activityId,Long untilId,int pageSize);
	//分页得到用户评论过的活动
	public List<Activity> getUserComedActByUntilId(long userId,long untilId,long pageSize);
	//
	public ActivityComment Comment(ActivityComment activityComment);
	////comment
	
	//统计某user_id发布的活动数
	public int getUserCreatedActNum(Long user_id);
}
