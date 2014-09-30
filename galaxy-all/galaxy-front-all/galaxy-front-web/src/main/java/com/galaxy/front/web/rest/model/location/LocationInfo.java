package com.galaxy.front.web.rest.model.location;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月27日 上午11:47:01
 *email :hsqmobile@gmail.com
 */
public class LocationInfo implements Serializable {
	/**
	 * 地点详细信息类
	 */
	private double longitude;// 经度
	private double latitude;// 维度

	private String address;// 详细地址,以后可以扩展为地址类

	public LocationInfo() {
		super();
	}

	public LocationInfo(double longitude, double latitude, String address) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
