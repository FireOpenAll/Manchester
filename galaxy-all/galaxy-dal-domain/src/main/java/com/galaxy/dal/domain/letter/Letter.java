package com.galaxy.dal.domain.letter;

import com.galaxy.dal.domain.BaseDomain;

public class Letter extends BaseDomain {
	private Long fromUserId;
	private Long toUserId;
	private String ip;
	private String type;
	private String content;
	private Boolean readFlag;
	private Boolean reply;
	private Integer status;
	public Long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public Long getToUserId() {
		return toUserId;
	}
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}
	public Boolean getReply() {
		return reply;
	}
	public void setReply(Boolean reply) {
		this.reply = reply;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	 
	
	

}
