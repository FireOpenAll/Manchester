package com.galaxy.front.web.rest.model.card;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年12月17日 上午11:35:13
 *email :hsqmobile@gmail.com
 */
public class CardApplyItemModel implements Serializable {

	private Long userId;
	private String avatar;// 头像URL
	private String username;// 名字
	private String company;// 公司
	private String title;// 职位
	private String applyMessage;
	private boolean addCard;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public String getApplyMessage() {
		return applyMessage;
	}
	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
	}
	public boolean isAddCard() {
		return addCard;
	}
	public void setAddCard(boolean addCard) {
		this.addCard = addCard;
	}
	
	
}
