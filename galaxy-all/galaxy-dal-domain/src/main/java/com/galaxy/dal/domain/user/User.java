package com.galaxy.dal.domain.user;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

public class User extends BaseDomain {

	private String loginName;

	private String sex;

	private Date birthday;// 2000-01-01 00:00:00 生日

	private UserType type;// 用户类型。普通用户，商家

	private String nick;// 昵称
	
	private int followers;
	
	private int fans;

	private String realName;// 真实姓名

	private String email;

	private String mobile;

	private String password;
	
	private String salt;//用于生成密码和校验密码

	private boolean realNameAuth;// 实名认证

	private boolean emailAuth;// 邮箱验证

	private boolean mobileAuth;// 手机验证
	
	private boolean hasPic;//是否有图片 
	
	private String avatar;// 用户头像url
	private String qqOpenid;// 绑定的openId
	private String webchatOpenid;// 绑定的openId
	private String weiboOpenid;// 绑定的openId 

	private Date lastVisitTime;// 上一次访问时间

	private UserStatus status;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isRealNameAuth() {
		return realNameAuth;
	}

	public void setRealNameAuth(boolean realNameAuth) {
		this.realNameAuth = realNameAuth;
	}

	public boolean isEmailAuth() {
		return emailAuth;
	}

	public void setEmailAuth(boolean emailAuth) {
		this.emailAuth = emailAuth;
	}

	public boolean isMobileAuth() {
		return mobileAuth;
	}

	public void setMobileAuth(boolean mobileAuth) {
		this.mobileAuth = mobileAuth;
	}

	public boolean isHasPic() {
		return hasPic;
	}

	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	 
 

	public String getQqOpenid() {
		return qqOpenid;
	}

	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}

	public String getWebchatOpenid() {
		return webchatOpenid;
	}

	public void setWebchatOpenid(String webchatOpenid) {
		this.webchatOpenid = webchatOpenid;
	}

	public String getWeiboOpenid() {
		return weiboOpenid;
	}

	public void setWeiboOpenid(String weiboOpenid) {
		this.weiboOpenid = weiboOpenid;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
 

}
