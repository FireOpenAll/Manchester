package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.activity.ChannelModel;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class ChannelController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "channels", method = RequestMethod.GET)
	public Object get() {
		List<ChannelModel> channelList = new ArrayList<ChannelModel>();
		for (int i = 0; i < 4; i++) {
			ChannelModel model = new ChannelModel();
			model.setTitle("title" + i);
			model.setPicUrl("http://url.com/" + i);
			model.setChannelId((long) i);
			channelList.add(model);
		}
		return channelList;
	}
}
