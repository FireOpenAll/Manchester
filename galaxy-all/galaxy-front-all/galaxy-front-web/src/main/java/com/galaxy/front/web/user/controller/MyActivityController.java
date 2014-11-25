package com.galaxy.front.web.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.front.web.model.activity.WebActivityModel;
import com.galaxy.front.web.model.page.Page;
import com.galaxy.front.web.utils.Constants;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserService;
import com.galaxy.service.user.UserUtils;

@Controller
@RequestMapping(value = "user/act")
public class MyActivityController {
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	
	//我发布了的活动
	@RequestMapping(value = "published",method=RequestMethod.GET)
	public String getMyPublishedActivity(HttpServletRequest request){
		
		LoginUserModel loginUserModel = UserUtils.getLoginUser();
		//System.out.println("loginUserModel.userid==================="+loginUserModel.getUserId());
		
		int pageNo = 1;
		int pageSize = Constants.PAGESIZE;
		int totalPages = 1;
		if(request.getParameter("pageNo") != null){
			pageNo = Integer.valueOf(request.getParameter("pageNo").toString());
			if (pageNo <1) {
				pageNo = 1;
			}
		}
		int totalItem = activityService.getUserCreatedActNum(loginUserModel.getUserId());
		totalPages = (totalItem%pageSize == 0)?(totalItem/pageSize):(totalItem/pageSize +1);
		
		if (totalItem != 0) {
			List<Activity> activities = activityService.getUserCreatedActByOffset(loginUserModel.getUserId(), (pageNo-1)*pageSize, pageSize);
			if (activities != null) {
				List<WebActivityModel> results = new ArrayList<WebActivityModel>();
				
				for(Activity activity:activities){
					WebActivityModel webActivityModel = new WebActivityModel();
					webActivityModel.setId(activity.getId());
					webActivityModel.setAddress(activity.getAddress());
					webActivityModel.setTitle(activity.getTitle());
					webActivityModel.setStart(activity.getStartTime());
					webActivityModel.setEnd(activity.getEndTime());
					webActivityModel.setThumnail(activity.getHaibao_urls().split(";")[0]);
					
					results.add(webActivityModel);
				}
				request.setAttribute("list", results);
				request.setAttribute("pageNo", pageNo);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("itemNum", results.size());
			}
		}
		return "user/act/mypublished";
	}
	
	//我参加的正在进行中的活动,待完成
	@RequestMapping(value = "joining",method=RequestMethod.GET)
	public String getMyJioningActivity(HttpServletRequest request){
		
		int currentPage = 1;
		int pageSize = 10;
		long userId = 1;
		int totalItem = activityService.getUserCreatedActNum(userId);
		Page<WebActivityModel> page = new Page<WebActivityModel>(currentPage, pageSize, totalItem);
		if (totalItem != 0) {
			List<Activity> activities = activityService.getUserCreatedActByOffset(userId, (page.getCurrentPage()-1)*page.getPageSize(), page.getPageSize());
			if (activities != null) {
				List<WebActivityModel> results = new ArrayList<WebActivityModel>();
				
				for(Activity activity:activities){
					WebActivityModel webActivityModel = new WebActivityModel();
					webActivityModel.setId(activity.getId());
					webActivityModel.setAddress(activity.getAddress());
					webActivityModel.setTitle(activity.getTitle());
					webActivityModel.setStart(activity.getStartTime());
					webActivityModel.setEnd(activity.getEndTime());
					webActivityModel.setThumnail(activity.getHaibao_urls().split(";")[0]);
					
					results.add(webActivityModel);
				}
				page.setList(results);
				request.setAttribute("list", results);
			}
		}
		
		
		return "user/act/myjoining";
	}
	
	//我参加过并完成的活动
	@RequestMapping(value = "joined",method=RequestMethod.GET)
	public String getMyJionedActivity(HttpServletRequest request){
		
		int currentPage = 1;
		int pageSize = 10;
		long userId = 1;
		int totalItem = activityService.getUserCreatedActNum(userId);
		Page<WebActivityModel> page = new Page<WebActivityModel>(currentPage, pageSize, totalItem);
		if (totalItem != 0) {
			List<Activity> activities = activityService.getUserCreatedActByOffset(userId, (page.getCurrentPage()-1)*page.getPageSize(), page.getPageSize());
			if (activities != null) {
				List<WebActivityModel> results = new ArrayList<WebActivityModel>();
				
				for(Activity activity:activities){
					WebActivityModel webActivityModel = new WebActivityModel();
					webActivityModel.setId(activity.getId());
					webActivityModel.setAddress(activity.getAddress());
					webActivityModel.setTitle(activity.getTitle());
					webActivityModel.setStart(activity.getStartTime());
					webActivityModel.setEnd(activity.getEndTime());
					webActivityModel.setThumnail(activity.getHaibao_urls().split(";")[0]);
					
					results.add(webActivityModel);
				}
				page.setList(results);
				request.setAttribute("list", results);
			}
		}
		
		
		return "user/act/myjoined";
	}
	
	
	@RequestMapping(value = "uncomment",method=RequestMethod.GET)
	public String getMyUncommentActivity(HttpServletRequest request){
		
		int currentPage = 1;
		int pageSize = 10;
		long userId = 1;
		int totalItem = activityService.getUserCreatedActNum(userId);
		Page<WebActivityModel> page = new Page<WebActivityModel>(currentPage, pageSize, totalItem);
		if (totalItem != 0) {
			List<Activity> activities = activityService.getUserCreatedActByOffset(userId, (page.getCurrentPage()-1)*page.getPageSize(), page.getPageSize());
			if (activities != null) {
				List<WebActivityModel> results = new ArrayList<WebActivityModel>();
				
				for(Activity activity:activities){
					WebActivityModel webActivityModel = new WebActivityModel();
					webActivityModel.setId(activity.getId());
					webActivityModel.setAddress(activity.getAddress());
					webActivityModel.setTitle(activity.getTitle());
					webActivityModel.setStart(activity.getStartTime());
					webActivityModel.setEnd(activity.getEndTime());
					webActivityModel.setThumnail(activity.getHaibao_urls().split(";")[0]);
					
					results.add(webActivityModel);
				}
				page.setList(results);
				request.setAttribute("list", results);
			}
		}
		
		
		return "user/act/myuncomment";
	}

	@RequestMapping(value = "commented",method=RequestMethod.GET)
	public String getMyUncommentedActivity(HttpServletRequest request){
		
		int currentPage = 1;
		int pageSize = 10;
		long userId = 1;
		int totalItem = activityService.getUserCreatedActNum(userId);
		Page<WebActivityModel> page = new Page<WebActivityModel>(currentPage, pageSize, totalItem);
		if (totalItem != 0) {
			List<Activity> activities = activityService.getUserCreatedActByOffset(userId, (page.getCurrentPage()-1)*page.getPageSize(), page.getPageSize());
			if (activities != null) {
				List<WebActivityModel> results = new ArrayList<WebActivityModel>();
				
				for(Activity activity:activities){
					WebActivityModel webActivityModel = new WebActivityModel();
					webActivityModel.setId(activity.getId());
					webActivityModel.setAddress(activity.getAddress());
					webActivityModel.setTitle(activity.getTitle());
					webActivityModel.setStart(activity.getStartTime());
					webActivityModel.setEnd(activity.getEndTime());
					webActivityModel.setThumnail(activity.getHaibao_urls().split(";")[0]);
					
					results.add(webActivityModel);
				}
				page.setList(results);
				request.setAttribute("list", results);
			}
		}
		
		
		return "user/act/mycommented";
	}
	 
}
