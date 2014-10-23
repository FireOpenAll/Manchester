/**
 * 
 */
package com.galaxy.service.chat;

/**
 * @author luolishu
 *
 */
public class ChatException extends RuntimeException {
	ChatExceptionCode code;
	public ChatException(ChatExceptionCode chatErrorCode){
		this.code=chatErrorCode;
	}
	public ChatException(ChatExceptionCode chatErrorCode,String message){
		super(message);
		this.code=chatErrorCode;
	}
	
	public ChatException(){ 
	}
	public ChatExceptionCode getCode() {
		return code;
	}
	public void setCode(ChatExceptionCode code) {
		this.code = code;
	}

}
