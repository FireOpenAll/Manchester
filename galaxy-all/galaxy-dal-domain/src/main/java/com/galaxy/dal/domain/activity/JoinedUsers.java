package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class JoinedUsers extends BaseDomain {
	private Long userId;
	private Long activityId;
	private int ticketNum;//购买门票
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
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	
	

}
