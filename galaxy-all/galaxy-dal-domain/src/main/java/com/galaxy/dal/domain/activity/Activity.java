package com.galaxy.dal.domain.activity;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

public class Activity extends BaseDomain {

	private String title;
	private Date startTime;
	private Date endTime;
	private Long provinceId;
	private Long cityId;
	private Long areaId;
	private String address;
	private Float price;
	private String detailUrl;
	private String tags;
	private Integer joinedNum;
	private Integer commentNum;
	private Integer ticketsNum;
	private Integer collectNum;
	private ActivityStatus activityStatus;
	private Boolean needAudit;
	private String phone;
	private String description;
	private String pictures;
	private String email;
	private Long catId1;
	private Long catId2;
	private Double longtitude;
	private Double latitude;
	private ActivityType activityType;
	private Long organizerId;
	private Boolean free;
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
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
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
	public Integer getTicketsNum() {
		return ticketsNum;
	}
	public void setTicketsNum(Integer ticketsNum) {
		this.ticketsNum = ticketsNum;
	}
	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public ActivityStatus getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(ActivityStatus activityStatus) {
		this.activityStatus = activityStatus;
	}
	public Boolean getNeedAudit() {
		return needAudit;
	}
	public void setNeedAudit(Boolean needAudit) {
		this.needAudit = needAudit;
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
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCatId1() {
		return catId1;
	}
	public void setCatId1(Long catId1) {
		this.catId1 = catId1;
	}
	public Long getCatId2() {
		return catId2;
	}
	public void setCatId2(Long catId2) {
		this.catId2 = catId2;
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
	public ActivityType getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	public Long getOrganizerId() {
		return organizerId;
	}
	public void setOrganizerId(Long organizerId) {
		this.organizerId = organizerId;
	}
	public Boolean getFree() {
		return free;
	}
	public void setFree(Boolean free) {
		this.free = free;
	}
	
	
}
