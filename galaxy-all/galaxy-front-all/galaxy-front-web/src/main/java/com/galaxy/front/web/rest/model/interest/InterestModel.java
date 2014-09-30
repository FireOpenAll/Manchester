package com.galaxy.front.web.rest.model.interest;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月20日 下午3:54:48
 *email :hsqmobile@gmail.com
 */
public class InterestModel implements Serializable {
	/*
	 * 用户兴趣Model
	 */
	long interest_id;// 兴趣id
	String interest_name;// 兴趣名
	String cover;// 兴趣封面
	String summary;// 摘要描述

	public InterestModel() {
		super();
	}

	public InterestModel(long interest_id, String interest_name, String cover, String summary) {
		super();
		this.interest_id = interest_id;
		this.interest_name = interest_name;
		this.cover = cover;
		this.summary = summary;
	}

	public long getInterest_id() {
		return interest_id;
	}

	public void setInterest_id(long interest_id) {
		this.interest_id = interest_id;
	}

	public String getInterest_name() {
		return interest_name;
	}

	public void setInterest_name(String interest_name) {
		this.interest_name = interest_name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
