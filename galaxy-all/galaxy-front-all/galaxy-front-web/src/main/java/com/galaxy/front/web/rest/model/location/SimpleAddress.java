package com.galaxy.front.web.rest.model.location;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月20日 下午4:16:03
 *email :hsqmobile@gmail.com
 */
public class SimpleAddress implements Serializable {
	/**
	 * 简单的地址类，只有省和市
	 */

	private String province;
	private String city;

	public SimpleAddress() {
		super();
	}

	public SimpleAddress(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
