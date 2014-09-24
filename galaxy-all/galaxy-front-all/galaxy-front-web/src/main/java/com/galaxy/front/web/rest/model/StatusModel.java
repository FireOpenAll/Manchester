package com.galaxy.front.web.rest.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月21日 下午5:17:14
 *email :hsqmobile@gmail.com
 */
public class StatusModel implements Serializable {
	/*
	 * 简单的状态返回model
	 */

	private String status;

	public StatusModel() {
		super();
	}

	public StatusModel(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
