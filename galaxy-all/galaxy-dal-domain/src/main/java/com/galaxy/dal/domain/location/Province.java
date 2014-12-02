package com.galaxy.dal.domain.location;

import java.io.Serializable;


/*author:huangshanqi
 *time  :2014年10月7日 下午11:54:54
 *email :hsqmobile@gmail.com
 */
public class Province implements Serializable{
	/*
	 * 省份Model
	 */
	private Integer id;
	private Integer provinceCode;
	private String provinceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	
}
