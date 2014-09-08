package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

public class Location extends BaseDomain {
	private String zip;//	String	是	310000	邮政编码
	private String city;//	String	否	杭州	所在城市（中文名称）
	private String state;//	String	否	浙江	所在省份（中文名称）
	private String country;//	String	否	中国	国家名称
	private String district;//
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	

}
