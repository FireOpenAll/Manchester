package com.galaxy.dal.domain.location;

import java.io.Serializable;


/*author:huangshanqi
 *time  :2014年10月8日 上午12:04:13
 *email :hsqmobile@gmail.com
 */
public class City implements Serializable{

	/*
	 * 城市类model
	 */
	private Integer id;
	private Integer city_code;
	private String city_name;
	private Integer province_code;

	public City() {
		super();
	}

	public City(int id, int city_code, String city_name, int province_code) {
		super();
		this.id = id;
		this.city_code = city_code;
		this.city_name = city_name;
		this.province_code = province_code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCity_code() {
		return city_code;
	}

	public void setCity_code(Integer city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Integer getProvince_code() {
		return province_code;
	}

	public void setProvince_code(Integer province_code) {
		this.province_code = province_code;
	}


}
