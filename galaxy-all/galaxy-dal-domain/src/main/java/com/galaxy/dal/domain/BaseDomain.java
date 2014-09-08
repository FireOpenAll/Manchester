/**
 * 
 */
package com.galaxy.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luolishu
 * 
 */
public class BaseDomain implements Serializable {
	private Long id;
	private Date createdTime;
	private Date updatedTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	

}
