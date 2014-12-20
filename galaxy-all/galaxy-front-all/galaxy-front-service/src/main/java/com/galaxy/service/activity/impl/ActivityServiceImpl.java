package com.galaxy.service.activity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityCollectMapper;
import com.galaxy.dal.activity.mapper.ActivityCommentMapper;
import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.activity.mapper.ActivityUserMapper;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityCollectUser;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.dal.domain.ticket.Ticket;
import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.ticket.mapper.TicketMapper;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;
import com.galaxy.service.chat.ChatService;

/*author:huangshanqi
 *time  :2014年12月3日 下午9:01:37
 *email :hsqmobile@gmail.com
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired 
	private ActivityMapper activityMappper;
	@Autowired 
	private ActivityDetailMapper activityDetailMapper;
	@Autowired
	private ActivityUserMapper activityUserMapper;
	@Autowired
	private ActivityCommentMapper activityCommentMapper;
	@Autowired
	private ActivityCollectMapper activityCollectMapper;
	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Autowired 
	private ChatService chatService; 
	
	@Override
	@Transactional
	public Long create(ActivityForm form) {
		Activity activity=createActivity(form);
		activityMappper.insert(activity);
		activityMappper.updateActUrlById(activity.getId(), "/activity/detail/"+activity.getId());
		ActivityDetail detail=this.createDetail(form);
		detail.setId(activity.getId());
		activityDetailMapper.insert(detail);
		
		chatService.createGroup(form.getTitle(), form.getOrganizerId(),activity.getId());
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
	public Activity getActivity(Long id) {
		// TODO Auto-generated method stub
		return activityMappper.getById(id);
	}
	
	@Override
	public ActivityDetail getDetailByActId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@Transactional
	public boolean modify(ActivityForm form) {
		Activity activity=activityMappper.getById(form.getId());
		
		activityMappper.update(activity);
		
		ActivityDetail detail=activityDetailMapper.getById(form.getId());
		activityDetailMapper.update(detail);
		return true;
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return activityMappper.deleteById(id);
	}

	
	@Override
	public List<Activity> getActivitySortInJoinNum(Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityMappper.getActivitySortInJoinNum(offset, pageSize);
	}

	@Override
	public List<Activity> getActivitySortInCommentNum(Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityMappper.getActivitySortInCommentNum(offset, pageSize);
	}

	@Override
	public List<Activity> getActivitySortInCreateTime(Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityMappper.getActivitySortInCreateTime(offset, pageSize);
	}
	
	
	@Override
	public List<Activity> getUserPublishActivity(Long userId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityMappper.getUserPublishActivity(userId, offset, pageSize);
	}
	

	@Override
	public boolean hasUserJoinedActivity(Long userId, Long activityId) {
		// TODO Auto-generated method stub
		ActivityUser temp = activityUserMapper.getByUserIdActId(userId, activityId);
		return temp != null;
	}

	@Override
	public boolean hasUserCollectedActivity(Long userId, Long activityId) {
		// TODO Auto-generated method stub
		ActivityCollectUser temp = activityCollectMapper.getByUserIdActId(userId, activityId);
		return temp != null;
	}

	
	
	
	
	//activityuser



	@Override
	public int getUserpublishedActNumber(Long userId) {
		// TODO Auto-generated method stub
		return activityMappper.getUserpublishedActNumber(userId);
	}

	@Override
	@Transactional
	public boolean joinActivity(ActivityUser activityUser) {
		Activity activity=activityMappper.getById(activityUser.getActivityId());
		if(activity==null){
			//todo error handle
			return false;
		}
		if(activity.getTicketsNum() < activityUser.getNum())
			return false;
		ActivityUser temp = activityUserMapper.getByUserIdActId(activityUser.getUserId(), activityUser.getActivityId());
		if(temp != null)
			return false;
		activityMappper.updateActivityJoinNum(activity.getId(), activity.getJoinedNum()+activityUser.getNum());
		activityMappper.updateActivityTicketNum(activity.getId(), activity.getTicketsNum() - activityUser.getNum());
		
		return activityUserMapper.insert(activityUser);
	}

	@Override
	public boolean unjoinActivity(ActivityUser activityUser) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean updateAcitvityUserInfo(ActivityUser activityUser) {
		// TODO Auto-generated method stub
		return activityUserMapper.update(activityUser);
	}

	@Override
	public ActivityUser getAcitvityUserById(Long id) {
		// TODO Auto-generated method stub
		return activityUserMapper.getById(id);
	}
	

	
	
	@Override
	public List<User> getAllJoinedUsersSortInTime(Long activityId) {
		// TODO Auto-generated method stub
		List<ActivityUser> tempList = activityUserMapper.getAllJoinedUsersSortInTime(activityId);
		if(tempList == null)
			return null;
		List<User> result = new ArrayList<User>();
		for(ActivityUser temp :tempList){
			User user = userMapper.getById(temp.getUserId());
			if(user != null)
				result.add(user);
		}
		return result;
	}

	@Override
	public List<User> getJoinedUsersSortInTime(Long activityId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		List<ActivityUser> tempList = activityUserMapper.getJoinedUsersSortInTime(activityId, offset, pageSize);
		if(tempList == null)
			return null;
		List<User> result = new ArrayList<User>();
		for(ActivityUser temp :tempList){
			User user = userMapper.getById(temp.getUserId());
			if(user != null)
				result.add(user);
		}
		return result;
	}

	@Override
	public int getUserJoinedActNumber(Long userId) {
		// TODO Auto-generated method stub
		return activityUserMapper.getUserJoinedActNumber(userId);
	}

	@Override
	public List<ActivityUser> getUserJoinedActs(Long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return activityUserMapper.getUserJoinedActs(userId, offset, pageSize);
	}


	//activityuser


	//comment

	@Override
	public int getUserComActNum(Long userId) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getUserComActNum(userId);
	}

	
	
	
	@Override
	public ArrayList<ActivityComment> getAllActComSortByTime(Long activityId) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getAllActComSortByTime(activityId);
	}

	@Override
	public ArrayList<ActivityComment> getActComSortByTime(Long activityId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getActComSortByTime(activityId, offset, pageSize);
	}

	@Transactional
	@Override
	public List<Activity> getUserComedActSortByTime(Long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		List<ActivityComment> comments = activityCommentMapper.getUserComedActSortByTime(userId, offset, pageSize);
		if(comments != null){
			ArrayList<Activity> result = new ArrayList<Activity>();
			for(ActivityComment comment : comments){
				Activity activity = activityMappper.getById(comment.getActivityId());
				if(activity != null)
					result.add(activity);
			}
			return result;
		}
		return null;
	}

	@Override
	@Transactional 
	public boolean commentActivity(ActivityComment activityComment) {
		// TODO Auto-generated method stub
		Activity activity = activityMappper.getById(activityComment.getActivityId());
		if(activity == null){
			return false;
		}
		activityMappper.updateActivityCommentNum(activity.getId(), activity.getCommentNum()+1);
		return activityCommentMapper.insert(activityComment);
	}

	@Override
	public boolean deleteComment(Long commentId) {
		// TODO Auto-generated method stub
		ActivityComment comment = activityCommentMapper.getById(commentId);
		if(comment == null){
			return false;
		}
		Activity activity = activityMappper.getById(comment.getActivityId());
		if(activity == null){
			return false;
		}
		activityMappper.updateActivityCommentNum(activity.getId(), (activity.getCommentNum()-1)>0?(activity.getCommentNum()+1):0);
		return activityCommentMapper.deleteById(commentId);
	}

	@Override
	public boolean modifyComment(ActivityComment activityComment) {
		// TODO Auto-generated method stub
		return activityCommentMapper.update(activityComment);
	}

	@Override
	public ActivityComment getCommentById(Long commentId) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getById(commentId);
	}


	@Override
	public ActivityUser getByUserIdActId(Long userId, Long activityId) {
		// TODO Auto-generated method stub
		return activityUserMapper.getByUserIdActId(userId, activityId);
	}

	

	//comment
	

	///collect
	@Override
	public boolean collectActivity(ActivityCollectUser activityCollectUser) {
		// TODO Auto-generated method stub
		ActivityCollectUser temp = activityCollectMapper.getByUserIdActId(activityCollectUser.getUserId(), activityCollectUser.getActivityId());
		if(temp != null)
			return false;
		Activity activity = activityMappper.getById(activityCollectUser.getActivityId());
		if(activity == null){
			return false;
		}
		activityMappper.updateActivityCollectNum(activity.getId(), activity.getCollectNum()+1);
		return activityCollectMapper.insert(activityCollectUser);
	}

	@Override
	public boolean cancelCollectActivity(Long collectId) {
		// TODO Auto-generated method stub
		return activityCollectMapper.deleteById(collectId);
	}

	@Override
	public int getUserCollectActNum(Long userId) {
		// TODO Auto-generated method stub
		return activityCollectMapper.getUserCollectActNum(userId);
	}

	@Override
	public List<ActivityCollectUser> getActCollectSortByTime(Long activityId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityCollectMapper.getActCollectSortByTime(activityId,offset,pageSize);
	}

	@Override
	public ArrayList<Activity> getUserCollectedActSortByTime(Long userId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		List<ActivityCollectUser> list = activityCollectMapper.getUserCollectedActSortByTime(userId, offset, pageSize);
		if(list != null){
			ArrayList<Activity> result = new ArrayList<Activity>();
			for(ActivityCollectUser collect:list){
				Activity activity = activityMappper.getById(collect.getActivityId());
				if(activity != null){
					result.add(activity);
				}
			}
			return result;
		}
		return null;
	}
	///collect
	
}
