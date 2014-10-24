package com.galaxy.front.web.utils;

import org.apache.ibatis.jdbc.SQL;

/*author:huangshanqi
 *time  :2014年10月7日 下午2:23:25
 *email :hsqmobile@gmail.com
 */
public enum Code {

	OK("20000", "ok"),
	FAILURE("59999","FAILURE"),
	
	EMAIL_FORMAT_ERROR("50000","邮箱格式错误"),
	EMAIL_USED("50001","邮箱已被注册"),
	EMAIL_NOT_AUTH("50002","邮箱没有认证"),
	
	PHONE_FORMAT_ERROR("50010","手机号码格式错误"),
	PHONE_USED("50011","手机号已被注册"),
	PHONE_NOT_AUTH("50012","手机未认证"),
	
	PASSWORD_FORMAT_ERROR("500020","密码格式错误"),
	PASSWORD_ERROR("50021","密码错误"),
	
	USER_NAME_FORMAT_ERROR("50030","用户名必须是字母、数字和下划线组成，以字母开头,6-20字符"),
	USER_NAME_USED("50031","用户名已被使用"),
	
	LOGIN_FAILED("50040","登陆失败，邮箱或密码错误"),
	
	REGISTER_ERROR("50050","注册失败，请从新注册"),
	
	PARAMS_ERROR("50008","参数错误"),
	
	//sql相关错误
	SQL_ADD_ERROR("51000","创建失败"),
	SQL_UPDATE_ERROR("51001","更新失败"),
	SQL_DELETE_ERROR("51002","删除失败"),
	SQL_ADD_EXISTS("51003","记录已存在或某字段不能重复"),
	SQL_SELECT_NOT_EXISTS("51004","没有此记录"),
	
	
	
	
	
	
	
	
	
	
	
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
