package com.galaxy.service.activity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityCommentMapper;
import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.activity.mapper.ActivityJoinedUsersMapper;
import com.galaxy.dal.activity.mapper.ActivityLikedUsersMapper;
import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.dal.domain.user.User;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;
import com.galaxy.service.chat.ChatService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;
@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	ActivityMapper activityMappper;
	@Autowired
	ActivityDetailMapper activityDetailMappper;
	@Autowired
	ActivityJoinedUsersMapper activityJoinedUsersMapper;
	@Autowired
	ActivityLikedUsersMapper activityLikedUsersMapper;
	@Autowired 
	ChatService chatService; 
	@Autowired 
	ActivityCommentMapper activityCommentMapper; 
	@Autowired
	UserService userService;
	
	////update
	@Override
	public boolean updateActlikedNum(int num, Long activityId) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityId);
		if (activity == null) {
			return false;
		}
		return activityMappper.updateActlikedNum(activity.getLiked_num()+1, activityId);
	}

	@Override
	public boolean updateActJoinedNum(int num, Long activityId) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityId);
		if (activity == null) {
			return false;
		}
		return activityMappper.updateActJoinedNum(activity.getJoinedNum()+1, activityId);
	}
	
	
	////update

	////create
	@Override
	@Transactional
	public Long create(ActivityForm form) {
		Activity activity=createActivity(form);
		activityMappper.insert(activity);
		ActivityDetail detail=this.createDetail(form);
		detail.setId(activity.getId());
		activityDetailMappper.insert(detail);
		
		chatService.createGroup(form.getTitle(), form.getUserId(),activity.getId());
		return activity.getId();
	}
	


	private Activity createActivity(ActivityForm form){
		Activity activity=new Activity();
		BeanUtils.copyProperties(form, activity);
		
		return activity;
	}
	private ActivityDetail createDetail(ActivityForm form){
		ActivityDetail detail=new ActivityDetail();
		BeanUtils.copyProperties(form, detail);
		return detail;
	}

	
	//分页获取某人发布的活动 
	@Override
	public List<Activity> getUserCreatedActByUntilId(long userId, long untilId, int pageSize) {
		// TODO Auto-generated method stub
		
		return activityMappper.getUserCreatedActByUntilId(userId, untilId, pageSize);
	}

	////create
	
    public List<Activity> getActsSortByJionedNum(int offset,int pageSize){
    	return activityMappper.getActsSortByJionedNum(offset, pageSize);
    }

	
	@Override
	@Transactional
	public boolean modify(ActivityForm form) {
		Activity activity=activityMappper.getById(form.getId());
		
		activityMappper.update(activity);
		
		ActivityDetail detail=activityDetailMappper.getById(form.getId());
		activityDetailMappper.update(detail);
		return true;
	}
	private void updateActivity(Activity activity,ActivityForm form){
		
	}
	@Override
	public boolean removeById(Long id) { 
		return activityMappper.deleteById(id);
	}

	@Override
	@Transactional
	public boolean joinActivity(Long activityId, Long userId) {
		Activity activity=activityMappper.getById(activityId);
		if(activity==null){
			//todo error handle
			return false;
		}
		
		ActivityJoinedUsers joinedUser=new ActivityJoinedUsers();
		LoginUserModel user=UserUtils.getLoginUser();
		joinedUser.setActivityId(activityId);
		joinedUser.setCreatedTime(new Date());
		joinedUser.setTicketNum(1);
		joinedUser.setUserId(user.getUserId());
		joinedUser.setUserName(user.getLoginName());
		activityJoinedUsersMapper.insert(joinedUser);
		activity.setJoinedNum(activity.getJoinedNum()+1);
		activityMappper.insert(activity);//activity参加人数+1
		return true;
	}
	
	

	@Override
	public Activity getActivity(Long id) {
		Activity activity=activityMappper.getById(id);
		return activity;
	}

	@Override
	public List<Activity> list(Map parameters, int size) {
		PaginationParam param=new PaginationParam();
		param.setPageData(parameters);
		param.setSize(size);
		List<Activity> results=activityMappper.list(param);
		return results;
	}

	////join
	@Override
	public List<ActivityJoinedUsers> listAllJoinedUsers(Long activityId) { 
		return activityJoinedUsersMapper.listAllJoinedUsers(activityId);
	}

	@Override
	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,Long fromId, int size) { 
		return activityJoinedUsersMapper.listAllJoinedUsersFromId(activityId, fromId, size);
	}
	
	
	@Override
	@Transactional
	public List<User> listTopActJionUser(Long activityId, int size) {
		// TODO Auto-generated method stub
		List<ActivityJoinedUsers> list = activityJoinedUsersMapper.listAllJoinedUsersFromId(activityId, 0L, size);
		if (list.size() <= 0) {
			return null;
		}
		List<User> users = new ArrayList<User>();
		for(ActivityJoinedUsers activityJoinedUsers:list){
			User user = userService.getUser(activityJoinedUsers.getUserId());
			if (user != null) {
				users.add(user);
			}
		}
		return users;
	}

	//计算user_id参加的活动数
	@Override
	public int getUserJoinedActNumber(Long user_id) {
		// TODO Auto-generated method stub
		return activityJoinedUsersMapper.getUserJoinedActNumber(user_id);
	}
     
	
	@Override
	@Transactional
	public List<Activity> listAllJoinedActs(Long userId) {
		// TODO Auto-generated method stub
		List<ActivityJoinedUsers> list = activityJoinedUsersMapper.listAllJoinedActs(userId);
		if (list == null || list.size() ==0) {
			return null;
		}
		List<Activity> activities = new ArrayList<Activity>();
		for (ActivityJoinedUsers activityJoinedUsers:list) {
			Activity activity = activityMappper.getById(activityJoinedUsers.getActivityId());
			if (activities != null) {
				activities.add(activity);
			}
		}
		return activities;
	}
	
	
	//用户user_id是否已参加某活动activity_id]
	@Override
	public boolean isUserJoinedActivity(Long userId,Long activityId){
		return (null == activityJoinedUsersMapper.getByUserIdActId(userId, activityId))?false:true;
	}

	////join


	////like
	@Override
	@Transactional
	public boolean likeActivity(ActivityLikedUsers activityLikedUsers) {
		//点赞某活动
		Activity activity = activityMappper.getById(activityLikedUsers.getActivityId());
		if (activity == null) {
			return false;
		}
		ActivityLikedUsers like = activityLikedUsersMapper.getByUserIdActId(activityLikedUsers.getUserId(), activityLikedUsers.getActivityId());
		if (like != null) {
			//已点赞
			return true;
		}
		
		return activityLikedUsersMapper.insert(activityLikedUsers) && activityMappper.updateActlikedNum(activity.getLiked_num()+1, activityLikedUsers.getActivityId());
	}
	
	@Override
	@Transactional
	public boolean cancelLiked(Long user_id, Long activity_id) {
		//取消点赞 
		Activity activity = activityMappper.getById(activity_id);
		if (activity == null) {
			return false;
		}
		ActivityLikedUsers like = activityLikedUsersMapper.getByUserIdActId(user_id, activity_id);
		if (like == null) {
			//未点赞
			return false;
		}
		return activityLikedUsersMapper.deleteById(like.getId()) && activityMappper.updateActlikedNum((activity.getLiked_num()-1)>0?(activity.getLiked_num()-1):0, activity_id);

     }
	
	@Override
	public List<ActivityLikedUsers> listAllLikedUsers(Long activity_id) {
		//分页列出某个活动点赞的用户
		List<ActivityLikedUsers> likedUsers = activityLikedUsersMapper.listAllLikedUsers(activity_id);
		return likedUsers;
	}

	@Override
	public List<ActivityLikedUsers> listAllLikedUsersByActId(PaginationParam paginationParam) {
		//分页列出某个活动点赞的用户
		List<ActivityLikedUsers> likedUsers = activityLikedUsersMapper.listAllLikedUsersByActId(paginationParam);
		return likedUsers;
	}
	
	@Override
	@Transactional
	public List<Activity> getUserLikedActByUntilId(long userId, long untilId, long pageSize) {
		// TODO Auto-generated method stub
		List<ActivityLikedUsers> list = activityLikedUsersMapper.getUserLikedActByUntilId(userId, untilId, pageSize);
		if (list == null || list.size() == 0) {
			return null;
		}
		List<Activity> results = new ArrayList<Activity>();
		for(ActivityLikedUsers activityLikedUsers : list){
			Activity activity = activityMappper.getById(activityLikedUsers.getActivityId());
			if (activity != null) {
				results.add(activity);
			}
		}
		return results;
	}

	@Override
	public int getLikedActNumByUserId(Long user_id) {
		//计算user_id Liked过的活动数
		return activityLikedUsersMapper.getLikedActNumByUserId(user_id);
	}

	@Override
	public boolean isUserLikedActivity(Long UserId, Long activityId) {
		// 用户是否已经点赞某活动
		return (null == activityLikedUsersMapper.getByUserIdActId(UserId, activityId))?false:true;
	}
	
	
	
	
	////like
	


	////comment
	//统计user_id评论过的活动数
	@Override
	public int getUserComActNum(Long user_id){
		return activityCommentMapper.getUserComActNum(user_id);
	}
	
	//统计某个活动总的评论人数
	@Override
	public int getCommUserNum(Long activityId) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getCommUserNum(activityId);
	}
	//评论活动或回复某个人
	@Override
	@Transactional
	public ActivityComment Comment(ActivityComment activityComment) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityComment.getActivityId());
		if (activity == null) {
			return null;
		}
		activityComment.setReplyTime(activityComment.getCreatedTime());
		activityCommentMapper.insert(activityComment);
		return activityComment;
	}

	//分页得到某活动的评论
	@Override
	@Transactional
	public List<ActivityComment> getActComByUntilId(Long activityId, Long untilId, int pageSize) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityId);
		if (activity == null) {
            return null;	
		}
		
		return activityCommentMapper.getActComByUntilId(activityId, untilId, pageSize);
	}
	
	
	//分页得到用户评论过的活动
	@Override
	@Transactional
	public List<Activity> getUserComedActByUntilId(long userId, long untilId, long pageSize) {
		// TODO Auto-generated method stub
		List<ActivityComment> list = activityCommentMapper.getUserComedActByUntilId(userId, untilId, pageSize);
		if (list == null || list.size() == 0) {
			return null;
		}
		List<Activity> results = new ArrayList<Activity>();
		for(ActivityComment activityComment : list){
			Activity activity = activityMappper.getById(activityComment.getActivityId());
			if (activity != null) {
				results.add(activity);
			}
		}
		return results;
	}
	
	
	
	////comment


	//统计某user_id发布的活动数
	@Override
	public int getUserCreatedActNum(Long user_id) {
		// TODO Auto-generated method stub
		return activityMappper.getUserCreatedActNum(user_id);
	}

	@Override
	public ActivityJoinedUsers getActivityJoinUserByUserId(Long activityId, Long userId) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityId);
		if (activity == null) {
			return null;
		}
		ActivityJoinedUsers activityJoinedUsers = activityJoinedUsersMapper.getByUserIdActId(userId, activityId);
		return activityJoinedUsers;
	}



	
	
}
