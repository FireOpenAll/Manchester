package com.galaxy.front.web.rest.model.activity;

import java.io.Serializable;
import java.util.Date;

public class HotItemModel  implements Serializable{
	private Long activityId;
	private String picUrl;
	private String title;
	private int like;
	private double price;
	private Date startTime;
	private Date endTime;
	private String address;
	private JoinedPeopleInfo joinedInfo;
	
	
	
	public Long getActivityId() {
		return activityId;
	}



	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}



	public String getPicUrl() {
		return picUrl;
	}



	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getLike() {
		return like;
	}



	public void setLike(int like) {
		this.like = like;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public JoinedPeopleInfo getJoinedInfo() {
		return joinedInfo;
	}



	public void setJoinedInfo(JoinedPeopleInfo joinedInfo) {
		this.joinedInfo = joinedInfo;
	}



	public static class JoinedPeopleInfo{
		int tatal;
		String avatars[];
		public int getTatal() {
			return tatal;
		}
		public void setTatal(int tatal) {
			this.tatal = tatal;
		}
		public String[] getAvatars() {
			return avatars;
		}
		public void setAvatars(String[] avatars) {
			this.avatars = avatars;
		}
		 
		
		
	}

	 
}
