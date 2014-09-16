package com.galaxy.front.web.rest.activity.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Paginations;
import com.galaxy.front.web.rest.model.activity.HotItemModel;
import com.galaxy.front.web.rest.model.activity.HotItemModel.JoinedPeopleInfo;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class HotsController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "hots", method = RequestMethod.GET)
	public Object get() {
		Paginations<HotItemModel> paginations = new Paginations<HotItemModel>();
		paginations.setPageNum(1);
		paginations.setPageSize(10);
		List<HotItemModel> dataList = new ArrayList<HotItemModel>();
		for (int i = 0; i < 10; i++) {
			HotItemModel model = new HotItemModel();
			model.setTitle("title" + i);
			model.setPicUrl("/activity/activityId/pic" + i + ".jpg");
			model.setActivityId((long) i);
			model.setLike(23);
			model.setStartTime(new Date());
			model.setEndTime(new Date());
			model.setAddress("北京市朝阳区");
			model.setTitle("title" + i);
			JoinedPeopleInfo joinedInfo = new JoinedPeopleInfo();
			joinedInfo.setTatal(121);
			joinedInfo.setAvatars(new String[] { "/avatars/userid/avatar.jpg",
					"/avatars/userid2/avatar.jpg" });
			model.setJoinedInfo(joinedInfo);
			dataList.add(model);
		}
		paginations.setDatas(dataList);
		return paginations;
	}
}
