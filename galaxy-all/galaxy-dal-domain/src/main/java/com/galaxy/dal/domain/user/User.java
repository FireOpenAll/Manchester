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

	private boolean realNameAuth;// 实名认证

	private boolean emailAuth;// 邮箱验证

	private boolean mobileAuth;// 手机验证
	
	private boolean hasPic;//是否有图片 
	
	private String avatar;// 用户头像url
	private String bindOpenId;// 绑定的openId

	private String bindPlatform;// 绑定平台

	private Date lastVisitTime;// 上一次访问时间

	private UserStatus status;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

}
