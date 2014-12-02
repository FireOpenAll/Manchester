package com.galaxy.dal.domain.card;

import java.io.Serializable;
import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年10月15日 下午4:50:31
 *email :hsqmobile@gmail.com
 */
public class Card extends BaseDomain{

	/* 名片实体类定义 */
	
	private Long user_id;

	private String username;// 名字

	private String company;// 公司

	private String title;// 职位

	private String phone;

	private String email;

	private String address;

	private String website;// 个人主页

	private String qq;

	private String weixin;

	private String photo;// 头像URL

	private String qrcodeUrl;// 名片二维码地址

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	

}
