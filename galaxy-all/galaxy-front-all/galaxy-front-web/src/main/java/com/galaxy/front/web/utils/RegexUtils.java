package com.galaxy.front.web.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*author:huangshanqi
 *time  :2014年10月7日 上午11:53:49
 *email :hsqmobile@gmail.com
 */
public class RegexUtils {
	/*
	 * 公共正则表达式验证
	 */
	
	public static final String PHONE_REGEX = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	public static final String EMAIL_REGEX = "^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]{6,20}$";
	public static final String SPECIAL_CHAR_REGEX = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
	/**
	 * 邮箱正则验证,符合返回true
	 */
	public static boolean checkEmail(String email){
		
		Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email);
		
		return emailMatcher.matches();
	}
	
	/**
	 * 手机号正则验证,符合返回true
	 */
	public static boolean checkPhone(String phone){
		Pattern phonePattern = Pattern.compile(PHONE_REGEX);
		Matcher phoneMatcher = phonePattern.matcher(phone);
		return phoneMatcher.matches();
	}
	
	/**
	 * 密码正则验证,符合返回true
	 * 字母数字下划线,6-20个
	 */
	public  static boolean checkPassword(String password){
		Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
		Matcher passwordMatcher = passwordPattern.matcher(password);
		return passwordMatcher.matches();
		
	}
	
	/**
	 * 是否有特许字符,有则ture
	 */
	public static boolean hasSpecialChar(String input){
		Pattern specialCharPattern = Pattern.compile(SPECIAL_CHAR_REGEX);
		Matcher specialCharMatcher = specialCharPattern.matcher(input);
		return specialCharMatcher.matches();
	}
	/**
	 * 用户名正则验证，符合返回true
	 * 不含特许字符，长度1-30
	 */
	public static boolean checkName(String name){
		return (!hasSpecialChar(name))&&(name.length()>1)&&(name.length()<30);
	}
	
	
	

}
