package com.galaxy.front.web.activity.controller.PostModel;

/*author:huangshanqi
 *time  :2014年10月14日 上午9:57:49
 *email :hsqmobile@gmail.com
 */
public class CreateModel {
	// 活动表单Formbean
	private String name;
	private String start_time;
	private String end_time;
	private Long province;
	private Long city;
	private Long district;
	private String address_detail;
	private String sponsor;
	private String phone;
	private String tags;
	private String description;
	private String detail;
	private String ticket_name;
	private int ticket_num;
	private Double ticket_price;
	private int optionsRadios;
	private Long catId1;
	private Long catId2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}

	public Double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public int getOptionsRadios() {
		return optionsRadios;
	}

	public void setOptionsRadios(int optionsRadios) {
		this.optionsRadios = optionsRadios;
	}

	public Long getCatId1() {
		return catId1;
	}

	public void setCatId1(Long catId1) {
		this.catId1 = catId1;
	}

	public Long getCatId2() {
		return catId2;
	}

	public void setCatId2(Long catId2) {
		this.catId2 = catId2;
	}



}
