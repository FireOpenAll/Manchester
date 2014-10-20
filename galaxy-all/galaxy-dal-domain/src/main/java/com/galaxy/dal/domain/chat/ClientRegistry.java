package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;

public class ClientRegistry extends BaseDomain {

	String deviceId;
	Long userId;
	String token;

	ClientType clientType;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	enum ClientType {
		ANDRIOD, ANDRIOD_HD, IOS, IPAD, MAC;

	}
}
