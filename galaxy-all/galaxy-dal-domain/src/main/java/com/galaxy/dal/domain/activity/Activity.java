package com.galaxy.dal.domain.activity;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

public class Activity extends BaseDomain {

	private ActivityType type;
	/**
	 * 分类级
	 */
	private Long catId1;
	private Long catId2;
	private Long catId3;

	private String status;
	private String title;
	private Date startTime;
	private Date endTime;
	private Long provinceId;
	private Long cityId;
	private Long districtId;
	private String address;

	private String refUrl;

	private Double price;

	private String tags;

	private Long userId;// 发布人ID

	private Long operatorId;// 操作人ID

	private Integer joinedNum;// 参会人数

	private Integer ticketsNum;// 门票数量

	// hsq
	private String haibao_urls;// 活动图片url，以";"分割
	private String phone;// 多个以";"分割
	private String email;

	private Double longtitude;

	private Double latitude;
	private String description;// 活动简介
	public ActivityType getType() {
		return type;
	}
	public void setType(ActivityType type) {
		this.type = type;
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
	public Long getCatId3() {
		return catId3;
	}
	public void setCatId3(Long catId3) {
		this.catId3 = catId3;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRefUrl() {
		return refUrl;
	}
	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getJoinedNum() {
		return joinedNum;
	}
	public void setJoinedNum(Integer joinedNum) {
		this.joinedNum = joinedNum;
	}
	public Integer getTicketsNum() {
		return ticketsNum;
	}
	public void setTicketsNum(Integer ticketsNum) {
		this.ticketsNum = ticketsNum;
	}
	public String getHaibao_urls() {
		return haibao_urls;
	}
	public void setHaibao_urls(String haibao_urls) {
		this.haibao_urls = haibao_urls;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
