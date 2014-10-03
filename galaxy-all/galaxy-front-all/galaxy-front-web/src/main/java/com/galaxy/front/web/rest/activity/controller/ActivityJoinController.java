/**
 * 
 */
package com.galaxy.front.web.rest.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.service.activity.ActivityService;

/**
 * @author luolishu
 * 
 */
@RestController
@RequestMapping(value = "/api/v1/activity")
public class ActivityJoinController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public Object join(Long id) {
		Activity activity = activityService.getActivity(id);
		if (activity == null) {

		}
		return null;
	}

}
