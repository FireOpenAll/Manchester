package com.galaxy.service.activity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityDetailMapper;
import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityDetail;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;
@Service
public class ActivityServiceImpl implements ActivityService {
	ActivityMapper activityMappper;
	ActivityDetailMapper activityDetailMappper;

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

	

}
