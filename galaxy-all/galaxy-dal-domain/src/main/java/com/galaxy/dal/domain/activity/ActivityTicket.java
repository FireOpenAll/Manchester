package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年12月6日 下午4:40:01
 *email :hsqmobile@gmail.com
 */
public class ActivityTicket extends BaseDomain {

	private Long activityId;
	private Long ticketId;
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
}
