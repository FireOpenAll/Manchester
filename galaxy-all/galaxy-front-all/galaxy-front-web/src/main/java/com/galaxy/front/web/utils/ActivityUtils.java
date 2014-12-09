package com.galaxy.front.web.utils;

import java.util.Date;

import com.galaxy.dal.domain.activity.ActivityStatus;
/*author:huangshanqi
 *time  :2014年12月6日 下午3:14:39
 *email :hsqmobile@gmail.com
 */
public class ActivityUtils {

	public static ActivityStatus getActivityStatus(Date startTime,Date endTime){
		Date now = new Date();
		if(now.after(endTime)){
			return ActivityStatus.finished;
		}
		if(now.before(startTime)){
			return ActivityStatus.unbegin;
		}
		return ActivityStatus.running;
		
	}
}
