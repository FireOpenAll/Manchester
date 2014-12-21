package com.galaxy.dal.domain.user;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年12月2日 下午5:12:53
 *email :hsqmobile@gmail.com
 */
public class User extends BaseDomain {

	private String LoginName;
	private String password;
	private Gender gender;
	private Date birthday;
	private UserType userType;// 个人、商家
	private String nick;
	private Integer friendNum;
	private String realName;
	private String email;
	private String mobile;
	private Boolean realNameAuth;
	private Boolean emailAuth;
	private Boolean mobileAuth;
	private String avatar;
	private String weiboOpenId;
	private String webcharOpenId;
	private String qqOpenId;
	private Date lastVisitTime;
	private UserStatus userStatus;// 状态
	private String salt;
	private String tags;
	private String region;

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(Integer friendNum) {
		this.friendNum = friendNum;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public Boolean getRealNameAuth() {
		return realNameAuth;
	}

	public void setRealNameAuth(Boolean realNameAuth) {
		this.realNameAuth = realNameAuth;
	}

	public Boolean getEmailAuth() {
		return emailAuth;
	}

	public void setEmailAuth(Boolean emailAuth) {
		this.emailAuth = emailAuth;
	}

	public Boolean getMobileAuth() {
		return mobileAuth;
	}

	public void setMobileAuth(Boolean mobileAuth) {
		this.mobileAuth = mobileAuth;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWeiboOpenId() {
		return weiboOpenId;
	}

	public void setWeiboOpenId(String weiboOpenId) {
		this.weiboOpenId = weiboOpenId;
	}

	public String getWebcharOpenId() {
		return webcharOpenId;
	}

	public void setWebcharOpenId(String webcharOpenId) {
		this.webcharOpenId = webcharOpenId;
	}

	public String getQqOpenId() {
		return qqOpenId;
	}

	public void setQqOpenId(String qqOpenId) {
		this.qqOpenId = qqOpenId;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
	
}
