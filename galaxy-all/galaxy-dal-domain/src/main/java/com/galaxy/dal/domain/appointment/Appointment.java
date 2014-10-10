/**
 * 
 */
package com.galaxy.dal.domain.appointment;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 *
 */
public class Appointment extends BaseDomain {
	Long userId;
	String subject;
	String address;
	Date startTime;
	Double longtitude;
	Double latitude;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	
	

}
