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
	private int id;
	private int province_code;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProvince_code() {
		return province_code;
	}

	public void setProvince_code(int province_code) {
		this.province_code = province_code;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

}
