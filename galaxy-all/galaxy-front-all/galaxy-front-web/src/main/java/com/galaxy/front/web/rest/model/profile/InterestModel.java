package com.galaxy.front.web.rest.model.profile;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月20日 下午3:54:48
 *email :hsqmobile@gmail.com
 */
public class InterestModel implements Serializable {
	/*
	 * 用户兴趣Model
	 */
	long interest_id;
	String interest_name;

	public InterestModel() {
		super();
	}

	public InterestModel(long interest_id, String interest_name) {
		super();
		this.interest_id = interest_id;
		this.interest_name = interest_name;
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

}
