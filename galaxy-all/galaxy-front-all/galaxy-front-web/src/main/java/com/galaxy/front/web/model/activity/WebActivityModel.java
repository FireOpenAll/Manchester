package com.galaxy.front.web.model.activity;

import java.util.Date;

/*author:huangshanqi
 *time  :2014年11月17日 下午11:30:50
 *email :hsqmobile@gmail.com
 */
public class WebActivityModel {
	 public Long id;
	 public Date start;
	 public Date end;
	 public String title;
	 public String address;
	 public String thumnail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	 
	 
}
