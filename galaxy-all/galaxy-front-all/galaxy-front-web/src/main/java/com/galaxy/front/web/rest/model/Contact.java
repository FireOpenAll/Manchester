package com.galaxy.front.web.rest.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月27日 上午11:42:02
 *email :hsqmobile@gmail.com
 */
public class Contact implements Serializable {
	/**
	 * 联系方式类,用于后期扩展
	 */
	private String phone;

	public Contact() {
		super();
	}

	public Contact(String phone) {
		super();
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
