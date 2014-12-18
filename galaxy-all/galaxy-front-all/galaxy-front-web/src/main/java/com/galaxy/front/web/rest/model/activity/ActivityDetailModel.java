package com.galaxy.front.web.rest.model.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年12月7日 上午10:21:28
 *email :hsqmobile@gmail.com
 */
public class ActivityDetailModel implements Serializable {

	private String title;
	private Date startTime;
	private Date endTime;
	private String address;
	private String detailUrl;
	private Float price;
	//
	private List<String> activityTags;
	
	private Integer joinedNum;
	private Integer commentNum;
	private Integer collectNum;
	private Integer ticketsNum;
	
	private String phone;
	private String description;
	
	//
	private List<String> activityPics;
	
	private String email;
	private Double longtitude;
	private Double latitude;
	
	private Long organizerId;
	//
	private String organizerNickName;
	
	//
	//private List<Ticket> tickets;
	
	
	//
	private List<UserModel> joinedUser;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public String getDetailUrl() {
		return detailUrl;
	}


	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}


	public List<String> getActivityTags() {
		return activityTags;
	}


	public void setActivityTags(List<String> activityTags) {
		this.activityTags = activityTags;
	}


	public Integer getJoinedNum() {
		return joinedNum;
	}


	public void setJoinedNum(Integer joinedNum) {
		this.joinedNum = joinedNum;
	}


	public Integer getCommentNum() {
		return commentNum;
	}


	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}


	public Integer getCollectNum() {
		return collectNum;
	}


	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public Integer getTicketsNum() {
		return ticketsNum;
	}


	public void setTicketsNum(Integer ticketsNum) {
		this.ticketsNum = ticketsNum;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<String> getActivityPics() {
		return activityPics;
	}


	public void setActivityPics(List<String> activityPics) {
		this.activityPics = activityPics;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Double getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Long getOrganizerId() {
		return organizerId;
	}


	public void setOrganizerId(Long organizerId) {
		this.organizerId = organizerId;
	}


	public String getOrganizerNickName() {
		return organizerNickName;
	}


	public void setOrganizerNickName(String organizerNickName) {
		this.organizerNickName = organizerNickName;
	}

	public List<UserModel> getJoinedUser() {
		return joinedUser;
	}


	public void setJoinedUser(List<UserModel> joinedUser) {
		this.joinedUser = joinedUser;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
}
