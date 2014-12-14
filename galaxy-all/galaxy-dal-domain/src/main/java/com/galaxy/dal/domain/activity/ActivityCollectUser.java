package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年12月2日 下午6:44:25
 *email :hsqmobile@gmail.com
 */
public class ActivityCollectUser extends BaseDomain {

	private Long userId;
	private Long activityId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	
}
