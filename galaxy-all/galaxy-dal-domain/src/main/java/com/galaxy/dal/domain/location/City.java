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
	private Integer cityCode;
	private String cityName;
	private Integer provinceCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}

	
}
