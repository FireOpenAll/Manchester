package com.galaxy.service.user;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.galaxy.cache.client.CacheClient;
@SuppressWarnings("rawtypes")
public abstract class UserUtils { 
	static CacheClient cachedClient = null;

	public static LoginUserModel getLoginUser() {
		LoginUserModel user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		return user;
	}

	public static LoginUserModel getUserByToken(String token) {
		LoginUserModel user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		if (user == null) {
			Subject subject=(Subject) cachedClient.get(token);
			if(subject==null){
				return null;
			}
			user = (LoginUserModel) subject.getPrincipal();
		} 
		return user;
	}
	 
	@SuppressWarnings("unchecked")
	public static void setSubject(String token,Subject subject) { 
		cachedClient.set(token,subject); ;
	}

}
