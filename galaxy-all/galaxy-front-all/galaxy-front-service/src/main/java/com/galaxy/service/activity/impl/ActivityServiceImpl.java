package com.galaxy.service.activity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityComment;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.dal.domain.activity.ActivityJoinedUser;
import com.galaxy.dal.domain.user.User;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;

/*author:huangshanqi
 *time  :2014年12月3日 下午9:01:37
 *email :hsqmobile@gmail.com
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Override
	public ActivityDetail getDetailByActId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(ActivityForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(ActivityForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Activity> getActsSortByJionedNum(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateActlikedNum(int num, Long activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateActJoinedNum(int num, Long activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Activity getActivity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> list(Map parameters, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getUserCreatedActByOffset(long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getUserCreatedActByUntilId(long userId, long untilId, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean joinActivity(Long activityId, Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unjoinActivity(Long activityId, Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Activity> listAllJoinedActs(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listTopActJionUser(Long activityId, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserJoinedActNumber(Long user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUserJoinedActivity(Long userId, Long activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Activity> getUserLikedActByUntilId(long userId, long untilId, long pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLikedActNumByUserId(Long user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean cancelLiked(Long user_id, Long activity_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserLikedActivity(Long UserId, Long activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserComActNum(Long user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActComNum(Long activityId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ActivityComment> getActComByUntilId(Long activityId, Long untilId, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getUserComedActByUntilId(long userId, long untilId, long pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityComment Comment(ActivityComment activityComment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserCreatedActNum(Long user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActivityJoinedUser getActivityJoinUserByUserId(Long activityId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
