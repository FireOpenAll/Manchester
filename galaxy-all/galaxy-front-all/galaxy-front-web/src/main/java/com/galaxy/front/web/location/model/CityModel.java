package com.galaxy.front.web.location.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:04:13
 *email :hsqmobile@gmail.com
 */
public class CityModel implements Serializable {

	/*
	 * 城市类model
	 */
	private int id;
	private int city_code;
	private String city_name;
	private int province_code;

	public CityModel() {
		super();
	}

	public CityModel(int id, int city_code, String city_name, int province_code) {
		super();
		this.id = id;
		this.city_code = city_code;
		this.city_name = city_name;
		this.province_code = province_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCity_code() {
		return city_code;
	}

	public void setCity_code(int city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getProvince_code() {
		return province_code;
	}

	public void setProvince_code(int province_code) {
		this.province_code = province_code;
	}

}
