package com.galaxy.front.web.rest.model.profile;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月20日 下午4:16:03
 *email :hsqmobile@gmail.com
 */
public class SimpleLocation implements Serializable {

	private String province;
	private String city;

	public SimpleLocation() {
		super();
	}

	public SimpleLocation(String province, String city) {
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
