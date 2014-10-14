package com.galaxy.dal.domain.email;

import com.galaxy.dal.domain.BaseDomain;

public class Email extends BaseDomain {
	Long fromId;
	Long toId;
	EmailType emailType;
	String from;
	String to;
	String json;
	String template;
	Integer status=0;//0代表初始化,1代表锁定,2代表发送

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}
	
	

}
