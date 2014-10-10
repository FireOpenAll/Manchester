/**
 * 
 */
package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 * 
 */
public class Lecture extends BaseDomain {
	Long activityId;
	Long conferenceId;
	String conferenceName;
	Long companyId;
	String companyName;
	Long userId;
	String mobile;
	String subject;
	String userName;// 讲师姓名
	String position;// 讲师职位描述 
	String desc;// 讲师描述 
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(Long conferenceId) {
		this.conferenceId = conferenceId;
	}
	public String getConferenceName() {
		return conferenceName;
	}
	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
