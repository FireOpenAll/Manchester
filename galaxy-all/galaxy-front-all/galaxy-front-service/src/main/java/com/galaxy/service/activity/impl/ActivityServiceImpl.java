package com.galaxy.service.activity.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityCommentMapper;
import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.activity.mapper.ActivityUserMapper;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityUser;
import com.galaxy.dal.domain.ticket.Ticket;
import com.galaxy.dal.ticket.mapper.TicketMapper;
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
	private TicketMapper ticketMapper;
	
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


	
	//activityuser

	@Override
	@Transactional
	public boolean joinActivity(ActivityUser activityUser) {
		Activity activity=activityMappper.getById(activityUser.getActivityId());
		if(activity==null){
			//todo error handle
			return false;
		}
		
		ActivityUser temp = activityUserMapper.getByUserIdActIdTicketId(activityUser.getUserId(), activityUser.getActivityId(),activityUser.getTicketId());
		if (temp != null) {
			return false;
		}else {
			Ticket ticket = ticketMapper.getById(activityUser.getTicketId()) ;
			if(ticket == null){
				return false;
			}
			//
			ticket.setUpdatedTime(new Date());
			ticket.setRemain((ticket.getTotal()-activityUser.getNum()>0)?(ticket.getTotal()-activityUser.getNum()):0);
			ticketMapper.update(ticket);
			//
			activityMappper.updateActivityJoinNum(activityUser.getActivityId(), activity.getJoinedNum() + activityUser.getNum());
			return activityUserMapper.insert(activityUser);
		}
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
	public List<ActivityUser> listJoinedUsersSortInTime(Long activityId, Date jionTime, int pageSize) {
		// TODO Auto-generated method stub
		return activityUserMapper.listJoinedUsersSortInTime(activityId, jionTime, pageSize);
	}

	@Override
	public int getUserJoinedActNumber(Long userId) {
		// TODO Auto-generated method stub
		return activityUserMapper.getUserJoinedActNumber(userId);
	}

	@Override
	public List<ActivityUser> listUserJoinedActs(Long userId, Date jionTime, int pageSize) {
		// TODO Auto-generated method stub
		return activityUserMapper.listUserJoinedActs(userId, jionTime, pageSize);
	}

	@Override
	public ActivityUser getByUserIdActIdTicketId(Long userId, Long activityId,Long ticketId) {
		// TODO Auto-generated method stub
		return activityUserMapper.getByUserIdActIdTicketId(userId, activityId, ticketId);
	}

	//activityuser


	//comment

	@Override
	public int getUserComActNum(Long userId) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getUserComActNum(userId);
	}

	@Override
	public List<ActivityComment> getActComSortByTime(Long activityId, Date commentTime, Integer pageSize) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getActComSortByTime(activityId, commentTime, pageSize);
	}

	@Override
	public List<ActivityComment> getUserComedActSortByTime(Long activityId, Long userId, Date commentTime, Long pageSize) {
		// TODO Auto-generated method stub
		return activityCommentMapper.getUserComedActSortByTime(activityId, userId, commentTime, pageSize);
	}

	@Override
	public boolean Comment(ActivityComment activityComment) {
		// TODO Auto-generated method stub
		return activityCommentMapper.insert(activityComment);
	}

	@Override
	public boolean deleteComment(Long commentId) {
		// TODO Auto-generated method stub
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
	

	
}
