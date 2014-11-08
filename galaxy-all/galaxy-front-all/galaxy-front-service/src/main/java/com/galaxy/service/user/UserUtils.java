package com.galaxy.service.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.galaxy.cache.client.CacheClient;
@SuppressWarnings("rawtypes")
public abstract class UserUtils { 
	static CacheClient cachedClient = null;

	public static LoginUserModel getLoginUser() {
		String token=UserContext.getContext().getToken();
		LoginUserModel user =null;
		if(StringUtils.isBlank(token)){
		 user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		}
		if(user==null){
			user=getUserByToken(UserContext.getContext().getToken());
		}
		return user;
	}

	@Deprecated
	private static LoginUserModel getUserByToken(String token) {
		LoginUserModel user = (LoginUserModel) SecurityUtils.getSubject()
				.getPrincipal();
		if (user == null) {
			user=(LoginUserModel) cachedClient.get(token);
			if(user==null){
				return null;
			} 
		} 
		return user;
	}
	 
	@SuppressWarnings("unchecked")
	public static void setUserModel(String token,Subject subject) { 
		cachedClient.set(token,subject.getPrincipal()); ;
	}
 

}
