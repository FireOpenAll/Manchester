package com.galaxy.service.user;

import java.io.Serializable;
import java.util.Date;

public class LoginUserModel implements Serializable{
	Long userId;
	String loginName;
	String nickName;
	String email;
	String mobile;
	String token;
	String expiredToken;
	Long expireshIn=7*24*60*60*1000L;
	Date loginedTime=new Date();
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	 
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getExpiredToken() {
		return expiredToken;
	}
	public void setExpiredToken(String expiredToken) {
		this.expiredToken = expiredToken;
	}
	public Long getExpireshIn() {
		return expireshIn;
	}
	public void setExpireshIn(Long expireshIn) {
		this.expireshIn = expireshIn;
	}
	public Date getLoginedTime() {
		return loginedTime;
	}
	public void setLoginedTime(Date loginedTime) {
		this.loginedTime = loginedTime;
	}
	
	public boolean isExpired(){
		return false;
	}
	
}
