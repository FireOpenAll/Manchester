package com.galaxy.service.user;

public class UserContext {
	
	static ThreadLocal<UserContext> threadLocal=new ThreadLocal<UserContext>();
	String token;
	
	public static UserContext  getContext(){
		return threadLocal.get();
	}
	
	public static void setContext(UserContext context){
		threadLocal.set(context);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
