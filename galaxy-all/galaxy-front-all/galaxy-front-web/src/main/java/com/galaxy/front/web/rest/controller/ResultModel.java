package com.galaxy.front.web.rest.controller;

import java.io.Serializable;

public class ResultModel implements Serializable {
	private String code;
	private String message="";
	private Serializable data;

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

	public Serializable getData() {
		return data;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

}
