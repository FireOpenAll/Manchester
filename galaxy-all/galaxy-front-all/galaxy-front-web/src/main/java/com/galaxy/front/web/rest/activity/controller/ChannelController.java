package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ChannelModel;
import com.galaxy.service.activity.ActivityService;

@RestController
@RequestMapping(value = "api/v1/activity")
public class ChannelController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "hots_channels", method = RequestMethod.GET)
	public Object get() {
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get hosts channels success");
		
		ArrayList<ChannelModel> channelList = new ArrayList<ChannelModel>();
		for (int i = 0; i < 4; i++) {
			ChannelModel channelModel = new ChannelModel();
			channelModel.setChannelId((long) (10001110+i));
			channelModel.setTitle("周末专场"+i);
			channelModel.setCover(new Photo("/interest/cover/"+(20+i)+".jpg","/interest/cover/"+(20+i)+".jpg","/interest/cover/"+(20+i)+".jpg"));
			channelModel.setType("interest");
			channelList.add(channelModel);
		}
		resultModel.setData(channelList);
		return resultModel;
	}
}
