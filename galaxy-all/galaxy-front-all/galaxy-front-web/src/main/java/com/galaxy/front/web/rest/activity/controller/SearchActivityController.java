package com.galaxy.front.web.rest.activity.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*author:huangshanqi
 *time  :2014年10月5日 下午5:25:10
 *email :hsqmobile@gmail.com
 */

import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.interest.InterestModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;


@RestController(value = "restSearchActivityController")
@RequestMapping(value ="api/v1/activity")
public class SearchActivityController {
	
	
	private final int MAX_PAGESIZE = 10;//分页最大数
	
	@RequestMapping(value = "search")
	public Object searchActivity(HttpServletRequest request){
		
		/*
		String queryString = request.getQueryString();
		
		
		ResultModel resultModel = new ResultModel();
		int pageSize = 0;
		int pageNum = 1;
		
		//页大小
		String pageSizeString = request.getParameter("pageSize") ;
		if (pageSizeString ==null) {
			pageSize = MAX_PAGESIZE;
		}else {
			pageSize = Integer.valueOf(pageSizeString);
			if (pageSize < 0 || pageSize > MAX_PAGESIZE) {
				pageSize = MAX_PAGESIZE;
			}
		}
		
		//页码
		String pageNumString = request.getParameter("pageNum");
		if (pageNumString == null) {
			pageNum = 1;
		}else {
			pageNum = Integer.valueOf(pageNumString);
			if (pageNum<0) {
				pageNum = 1;
			}
		}
		
		request.get
		*/
		
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get gold time success");
		
        ArrayList<ActivityModel> recomment_activity = new ArrayList<ActivityModel>();
		
		ArrayList<UserModel> relative_user = new ArrayList<UserModel>();
		for (int i = 1; i < 6; i++) {
			relative_user.add(new UserModel(100000000L, "/user/avatar/"+10*i+".jpg", "name"+i, (i%2==0)?"male":"female"));
		}
		
		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 1; i < 4; i++) {
			photos.add(new Photo("/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg", "/interest/cover/"+(10+i)+".jpg"));
		}
		
		ArrayList<InterestModel> interest_list = new ArrayList<InterestModel>();
		for (int i = 0; i < 4; i++) {
			interest_list.add(new InterestModel(10000000+i, "兴趣"+i, "/interest/cover/" + (20 + i) + ".jpg", "兴趣介绍"));
		}
		
		for (int i = 0; i < 10; i++) {
			//recomment_activity.add(new ActivityModel("activity",1110001100L, 123456789L, "活动"+i, (float)(90.69+i), (i%2==0)?true:false, (++i%2==0)?true:false, i+"组织者", new Date(), new Date(), new Contact("12345678901"), "活动摘要"+i, "/activity/"+i, photos, new LocationInfo(100.12+i*2,120.89+i*3,"北京市海淀区西土城路"), relative_user));
			recomment_activity.add(
					new ActivityModel("activity", (long)11110000+i, "活动名"+i*2, (float)(10.111+i),
					(i%2==0)?true:false, 100*i, (i%2!=0)?true:false, 200*i,300*i, "组织者 "+i+" 号", 
							addDate((i/2)*2), new Date(i*3), new Contact("1234567890"+i), "活动"+i+"摘要", "活动"+i+"url", photos,  
							new LocationInfo(100.12 + i * 2,120.89 + i * 3, "北京市海淀区西土城路"), 
					relative_user, interest_list)
					);
		}
		resultModel.setData(recomment_activity);
		
		return resultModel;
	}

	
	
	
	
	/**日期加减函数
	 * @param day=天数
	 * @return
	 */
	public Date addDate(int day) {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, day);
		return new Date(c.getTimeInMillis());
	}
}
