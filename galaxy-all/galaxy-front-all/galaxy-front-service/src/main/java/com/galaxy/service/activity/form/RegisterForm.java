/**
 * 
 */
package com.galaxy.service.activity.form;

import java.io.Serializable;

/**
 * @author luolishu
 * 
 */
public class RegisterForm implements Serializable {
	String username;
	String email;
	String password; 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
