/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galaxy.front.web.rest.model.activity.ActivityModel;

/**
 * @author luolishu
 * 
 */
@Controller
@RequestMapping(value = "activity")
public class ActivityDetailController {
	@RequestMapping(value = "detail/{id}.html")
	public String details(@PathVariable Long id,Model model) {
		ActivityModel activity=new ActivityModel();
		/*
		activity.setTitle("奥林匹克公园聚会");
		activity.setId(100L);
		activity.setStartTime(new Date());
		activity.setEndTime(new Date());
		activity.setAddress("奥林匹克公园 水立方");
		activity.setDetail("<div>活动详情介绍：<img height=\"425\" src=\"http://p1.meituan.net/deal/__40477445__6945085.jpg\" alt=\"美团图\" class=\"standard-image\" /></div>");
		model.addAttribute(activity);
		model.addAttribute("activity",activity);
		*/
		return "activity/detail";
	}

}
