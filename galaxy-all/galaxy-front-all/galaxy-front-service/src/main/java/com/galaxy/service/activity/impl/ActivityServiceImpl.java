package com.galaxy.service.activity.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.activity.mapper.ActivityJoinedUsersMapper;
import com.galaxy.dal.activity.mapper.ActivityLikedUsersMapper;
import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityJoinedUsers;
import com.galaxy.dal.domain.activity.ActivityLikedUsers;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;
import com.galaxy.service.user.LoginUserModel;
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

	@Override
	@Transactional
	public Long create(ActivityForm form) {
		Activity activity=createActivity(form);
		activityMappper.insert(activity);
		ActivityDetail detail=this.createDetail(form);
		detail.setId(activity.getId());
		activityDetailMappper.insert(detail);
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
		return false;
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
	public List<ActivityJoinedUsers> listAllJoinedUsersFromId(Long activityId,
			Long fromId, Long size) { 
		return activityJoinedUsersMapper.listAllJoinedUsersFromId(activityId, fromId, size);
	}
	
	//计算user_id参加的活动数
	@Override
	public int getUserJoinedActNumber(Long user_id) {
		// TODO Auto-generated method stub
		return activityJoinedUsersMapper.getUserJoinedActNumber(user_id);
	}


	////join
	
	////like
	@Override
	public boolean likeActivity(ActivityLikedUsers activityLikedUsers) {
		//点赞某活动
		return activityLikedUsersMapper.insert(activityLikedUsers);
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
	public int getLikedActNumByUserId(Long user_id) {
		//计算user_id Liked过的活动数
		return activityLikedUsersMapper.getLikedActNumByUserId(user_id);
	}

	@Override
	public boolean cancelLiked(Long user_id, Long activity_id) {
		//取消点赞 
		return activityLikedUsersMapper.cancelLiked(user_id, activity_id);
	}
	
	
	
	////like

}
