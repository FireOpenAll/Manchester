package com.galaxy.service.user;

import org.apache.shiro.SecurityUtils;

public abstract class UserUtils {
	
	public static LoginUserModel getLoginUser(){ 
		LoginUserModel user=(LoginUserModel) SecurityUtils.getSubject();
		return user;
	}
	
	public static LoginUserModel getUserByToken(String token){
		return null;
	}
 
}
