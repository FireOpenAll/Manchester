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
	private Integer province_code;
	private String province_name;

	public Province() {
		super();
	}

	public Province(int id, int province_code, String province_name) {
		super();
		this.id = id;
		this.province_code = province_code;
		this.province_name = province_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvince_code() {
		return province_code;
	}

	public void setProvince_code(Integer province_code) {
		this.province_code = province_code;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
 

}
