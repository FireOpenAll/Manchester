package com.galaxy.front.web.rest.model.user;

import java.io.Serializable;
import java.util.Date;

public class AuthResultModel implements Serializable {

	private long userId;// 用户id
	private String accessToken;// 访问token
	private String refreshToken;// 刷新token
	private long expireshIn;// token过期时间
	private Date create;// accesstoken创建时间

	public AuthResultModel() {
		super();
	}

	public AuthResultModel(long userId, String accessToken, String refreshToken, long expireshIn, Date create) {
		super();
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expireshIn = expireshIn;
		this.create = create;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public long getExpireshIn() {
		return expireshIn;
	}

	public void setExpireshIn(long expireshIn) {
		this.expireshIn = expireshIn;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

}
