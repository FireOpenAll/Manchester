package com.galaxy.dal.domain.card;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2014年10月15日 下午4:50:31
 *email :hsqmobile@gmail.com
 */
public class Card  implements Serializable{

	/* 名片实体类定义 */
	private Long card_id;
	private Date createdTime;
	private Date updatedTime;
	
	private Long user_id;

	private String name;// 名字

	private String company;// 公司

	private String title;// 职位

	private String phone;

	private String email;

	private String address;

	private String website;// 个人主页

	private String qq;

	private String weixin;

	private String photo;// 头像URL

	private String qrcode;// 名片二维码地址
	

	public Long getCard_id() {
		return card_id;
	}

	public void setCard_id(Long card_id) {
		this.card_id = card_id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("card_id=").append(this.getCard_id()).append(",");
		stringBuilder.append("user_id=").append(this.getUser_id()).append(",");
		stringBuilder.append("name=").append(this.getName()).append(",");
		stringBuilder.append("company=").append(this.getCompany()).append(",");
		stringBuilder.append("title=").append(this.getTitle()).append(",");
		stringBuilder.append("phone=").append(this.getPhone()).append(",");
		stringBuilder.append("email=").append(this.getEmail()).append(",");
		stringBuilder.append("address=").append(this.getAddress());
		stringBuilder.append("website=").append(this.getWebsite()).append(",");
		stringBuilder.append("qq=").append(this.getQq()).append(",");
		stringBuilder.append("weixin=").append(this.getWeixin()).append(",");
		stringBuilder.append("photo=").append(this.getPhoto()).append(",");
		stringBuilder.append("qrcode=").append(this.getQrcode()).append(",");
		return stringBuilder.toString();
	}
	
	

}