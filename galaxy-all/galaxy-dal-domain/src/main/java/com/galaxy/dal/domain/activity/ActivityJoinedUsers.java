package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

public class ActivityJoinedUsers extends BaseDomain {
	private Long userId;
	private String userName;
	private String realName;
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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

	public enum Status{
		INIT,
		AUDIT;
		
	}

}
