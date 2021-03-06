package com.galaxy.service.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityCollectUser;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.dal.domain.user.User;
import com.galaxy.service.activity.form.ActivityForm;

public interface ActivityService {
	public Activity getActivity(Long id);
	public Long create(ActivityForm form);
	public ActivityDetail getDetailByActId(Long id);
	
	public List<Activity> getActivitySortInJoinNum(Integer offset,Integer pageSize);
	public List<Activity> getActivitySortInCommentNum(Integer offset,Integer pageSize);
	public List<Activity> getActivitySortInCreateTime(Integer offset,Integer pageSize);
	
	public boolean modify(ActivityForm form);
	public boolean removeById(Long id);
	
	public int getUserpublishedActNumber(Long userId);
	public List<Activity> getUserPublishActivity(Long userId,Integer offset,Integer pageSize);

	public boolean hasUserJoinedActivity(Long userId,Long activityId);
	public boolean hasUserCollectedActivity(Long userId,Long activityId);
	
	//ActivityUser
	public boolean joinActivity(ActivityUser activityUser);
	public boolean unjoinActivity(Long userId,Long activityId);
	public boolean updateAcitvityUserInfo(ActivityUser activityUser);
	public ActivityUser getAcitvityUserById(Long id);
	public List<User> getAllJoinedUsersSortInTime(Long activityId);
	public List<User> getJoinedUsersSortInTime(Long activityId,int offset, int pageSize);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(Long userId);
	
	public List<Activity> getUserJoinedActs(Long userId,int offset,int pageSize);
	
	public ActivityUser getByUserIdActId( Long userId,Long activityId);
	
	//ActivityUser
	
	
	
	////comment
	//统计user_id评论过的活动数
	public int getUserComActNum(Long userId);
	//分页得到某活动的评论
	public ArrayList<ActivityComment> getActComSortByTime(Long activityId,Integer offset,Integer pageSize);
	public ArrayList<ActivityComment> getAllActComSortByTime(Long activityId);
	//分页得到用户评论过的活动
	public List<Activity> getUserComedActSortByTime(Long userId,int offset,int pageSize);
	public boolean commentActivity(ActivityComment activityComment);
	public ActivityComment getCommentById(Long commentId);
	public boolean deleteComment(Long commentId);
	public boolean modifyComment(ActivityComment activityComment);
	////comment
	
	
	///collect
	public boolean collectActivity(ActivityCollectUser activityCollectUser);
	public boolean cancelCollectActivity(Long userId,Long activityId);
	public int getUserCollectActNum(Long userId);
	public List<ActivityCollectUser> getActCollectSortByTime(Long activityId,Integer offset,Integer pageSize);
	public ArrayList<Activity>getUserCollectedActSortByTime(Long userId,Integer offset,Integer pageSize);
	///collect
	
	
	
	
	
	/*

	////detail
	
	////detail
	
	
	public boolean modify(ActivityForm form);

	public boolean removeById(Long id);

    public List<Activity> getActsSortByJionedNum(int offset,int pageSize);
    ////update
    public boolean updateActlikedNum(int num,Long activityId);
    public boolean updateActJoinedNum(int num,Long activityId);

    
    ////update

	

	public List<Activity> list(Map parameters, int size);
	////create
	//分页获取某人发布的活动 
	public List<Activity> getUserCreatedActByOffset (long userId,int offset,int pageSize);
	public List<Activity> getUserCreatedActByUntilId (long userId,long untilId,int pageSize);

	////create
	
	////join
	public boolean joinActivity(Long activityId, Long userId);
	public boolean unjoinActivity(Long activityId, Long userId);
	
	//用户参加的所有活动
	public List<Activity> listAllJoinedActs(Long userId);
	
	
	//列出某活动的前几个参加用户
	public List<User> listTopActJionUser(Long activityId,int num);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(Long user_id);
	
	//用户user_id是否已参加某活动activity_id]
	public boolean isUserJoinedActivity(Long userId,Long activityId);

	////join
	
	
	////like
	
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
	public int getActComNum(Long activityId);
	//分页得到某活动的评论
	public List<ActivityComment> getActComByUntilId(Long activityId,Long untilId,int pageSize);
	//分页得到用户评论过的活动
	public List<Activity> getUserComedActByUntilId(long userId,long untilId,long pageSize);
	//
	public ActivityComment Comment(ActivityComment activityComment);
	////comment
	
	//统计某user_id发布的活动数
	public int getUserCreatedActNum(Long user_id);
	public ActivityJoinedUser getActivityJoinUserByUserId(Long activityId, Long userId);
*/


}
