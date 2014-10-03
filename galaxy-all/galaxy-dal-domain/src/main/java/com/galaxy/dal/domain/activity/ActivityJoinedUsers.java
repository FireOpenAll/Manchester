package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class ActivityJoinedUsers extends BaseDomain {
	private Long userId;
	private String userName;
	private Long activityId;
	
	private int ticketNum;//购买门票
	private Status status;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	enum Status{
		INIT,
		AUDIT;
		
	}

}
