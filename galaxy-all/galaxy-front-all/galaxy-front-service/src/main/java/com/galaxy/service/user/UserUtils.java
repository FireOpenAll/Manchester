package com.galaxy.service.user;

import org.apache.shiro.SecurityUtils;

import com.galaxy.cache.client.CacheClient;

public abstract class UserUtils {
	static CacheClient<?> cachedClient = null;

	public static LoginUserModel getLoginUser() {
		LoginUserModel user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		return user;
	}

	public static LoginUserModel getUserByToken(String token) {
		LoginUserModel user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		if (user == null) {
			user = (LoginUserModel) cachedClient.get(token);
		}
		SecurityUtils.getSubject()
		return user;
	}
	 

}
