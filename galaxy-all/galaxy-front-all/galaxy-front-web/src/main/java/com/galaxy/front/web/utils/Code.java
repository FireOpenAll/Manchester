package com.galaxy.front.web.utils;

/*author:huangshanqi
 *time  :2014年10月7日 下午2:23:25
 *email :hsqmobile@gmail.com
 */
public enum Code {

	OK("20000", "ok"),
	
	
	EMAIL_FORMAT_ERROR("50000","邮箱格式错误"),
	EMAIL_USED("50001","邮箱已被注册"),
	PHONE_FORMAT_ERROR("50002","手机号码格式错误"),
	PHONE_USED("50003","手机号已被注册"),
	PASSWORD_FORMAT_ERROR("50005","密码格式错误"),
	PASSWORD_ERROR("50005","密码错误"),
	
	USER_NAME_FORMAT_ERROR("50006","用户名格式错误,不得包含特许字符，最长30个字符"),
	USER_NAME_USED("50007","用户名已被使用"),
	
	PARAMS_ERROR("50008","参数错误")
	
	
	
	
	
	
	
	
	
	
	;
	
	
	
	
	
	

	private  String code;// 错误码
	private String  message; // 错误信息

	private Code(String code, String message) {
		this.code = code;
		this.message = message;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
