package com.galaxy.front.web.location.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:04:34
 *email :hsqmobile@gmail.com
 */
public class DistrictModel implements Serializable {
	/*
	 * 区model
	 */
	private int id;
	private int district_code;
	private String district_name;
	private int city_code;

	public DistrictModel() {
		super();
	}

	public DistrictModel(int id, int district_code, String district_name, int city_code) {
		super();
		this.id = id;
		this.district_code = district_code;
		this.district_name = district_name;
		this.city_code = city_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(int district_code) {
		this.district_code = district_code;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public int getCity_code() {
		return city_code;
	}

	public void setCity_code(int city_code) {
		this.city_code = city_code;
	}

}
