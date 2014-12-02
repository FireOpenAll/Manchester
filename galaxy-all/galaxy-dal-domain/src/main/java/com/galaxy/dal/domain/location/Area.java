package com.galaxy.dal.domain.location;

import java.io.Serializable;


/*author:huangshanqi
 *time  :2014年10月8日 上午12:04:34
 *email :hsqmobile@gmail.com
 */
public class Area implements Serializable{
	/*
	 * 区model
	 */
	private Integer id;
	private Integer areaCode;
	private String dareaName;
	private Integer cityCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public String getDareaName() {
		return dareaName;
	}
	public void setDareaName(String dareaName) {
		this.dareaName = dareaName;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	
}
