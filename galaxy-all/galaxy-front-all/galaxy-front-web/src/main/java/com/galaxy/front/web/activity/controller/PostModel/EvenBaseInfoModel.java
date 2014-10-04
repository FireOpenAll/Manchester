package com.galaxy.front.web.activity.controller.PostModel;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月3日 上午10:20:04
 *email :hsqmobile@gmail.com
 */
public class EvenBaseInfoModel implements Serializable {
	
	

	private String event_name;// 活动名称
	private String event_type;//活动类型，线上、线下
	private String city_name;// 活动城市
	private String event_start_time;// 开始时间
	private String event_end_time;// 结束时间
	private String event_address_name;// 地点名称

	private Double event_longitude;// 经度
	private Double event_latitude;// 纬度

	private String event_address_info;// 详细地址
	private String refer_telephone;// 电话

	private int event_yinsi;// (1=公开,2=不公开)

	private Long event_category1;// 活动类型id，下拉列表id

	private String description;// 活动简介
	
	private String haibao_urls;//活动海报,"；"分割，最多三个图片 

	public EvenBaseInfoModel() {
		super();
	}


	public EvenBaseInfoModel(String event_name, String event_type, String city_name, String event_start_time,
			String event_end_time, String event_address_name, Double event_longitude, Double event_latitude,
			String event_address_info, String refer_telephone, int event_yinsi, Long event_category1,
			String description, String haibao_urls) {
		super();
		this.event_name = event_name;
		this.event_type = event_type;
		this.city_name = city_name;
		this.event_start_time = event_start_time;
		this.event_end_time = event_end_time;
		this.event_address_name = event_address_name;
		this.event_longitude = event_longitude;
		this.event_latitude = event_latitude;
		this.event_address_info = event_address_info;
		this.refer_telephone = refer_telephone;
		this.event_yinsi = event_yinsi;
		this.event_category1 = event_category1;
		this.description = description;
		this.haibao_urls = haibao_urls;
	}



	public String getEvent_name() {
		return event_name;
	}


	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}


	public String getEvent_type() {
		return event_type;
	}


	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}


	public String getCity_name() {
		return city_name;
	}


	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}


	public String getEvent_start_time() {
		return event_start_time;
	}


	public void setEvent_start_time(String event_start_time) {
		this.event_start_time = event_start_time;
	}


	public String getEvent_end_time() {
		return event_end_time;
	}


	public void setEvent_end_time(String event_end_time) {
		this.event_end_time = event_end_time;
	}


	public String getEvent_address_name() {
		return event_address_name;
	}


	public void setEvent_address_name(String event_address_name) {
		this.event_address_name = event_address_name;
	}


	public Double getEvent_longitude() {
		return event_longitude;
	}


	public void setEvent_longitude(Double event_longitude) {
		this.event_longitude = event_longitude;
	}


	public Double getEvent_latitude() {
		return event_latitude;
	}


	public void setEvent_latitude(Double event_latitude) {
		this.event_latitude = event_latitude;
	}


	public String getEvent_address_info() {
		return event_address_info;
	}


	public void setEvent_address_info(String event_address_info) {
		this.event_address_info = event_address_info;
	}


	public String getRefer_telephone() {
		return refer_telephone;
	}


	public void setRefer_telephone(String refer_telephone) {
		this.refer_telephone = refer_telephone;
	}


	public int getEvent_yinsi() {
		return event_yinsi;
	}


	public void setEvent_yinsi(int event_yinsi) {
		this.event_yinsi = event_yinsi;
	}


	public Long getEvent_category1() {
		return event_category1;
	}


	public void setEvent_category1(Long event_category1) {
		this.event_category1 = event_category1;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getHaibao_urls() {
		return haibao_urls;
	}


	public void setHaibao_urls(String haibao_urls) {
		this.haibao_urls = haibao_urls;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder("");
		sBuilder.append("event_name=").append(this.getEvent_name()).append(", ");
		sBuilder.append("event_type=").append(this.getEvent_type()).append(", ");
		sBuilder.append("city_name=").append(this.getCity_name()).append(", ");
		sBuilder.append("event_start_time=").append(this.getEvent_start_time()).append(", ");
		sBuilder.append("event_end_time=").append(this.getEvent_end_time()).append(", ");
		sBuilder.append("event_address_name=").append(this.getEvent_address_name()).append(", ");
		sBuilder.append("event_longitude=").append(this.getEvent_longitude()).append(", ");
		sBuilder.append("event_latitude=").append(this.getEvent_latitude()).append(", ");
		sBuilder.append("event_address_info=").append(this.getEvent_address_info()).append(", ");
		sBuilder.append("refer_telephone=").append(this.getRefer_telephone()).append(", ");
		sBuilder.append("event_yinsi=").append(this.getEvent_yinsi()).append(", ");
		sBuilder.append("event_category1=").append(this.getEvent_category1()).append(", ");
		sBuilder.append("haibao_urls=").append(this.getHaibao_urls()).append(", ");
		sBuilder.append("description=").append(this.getDescription());
		return sBuilder.toString();
	}

	
	
}
