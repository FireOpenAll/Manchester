package com.galaxy.front.web.rest.model.user;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月24日 下午11:04:24
 *email :hsqmobile@gmail.com
 */
public class FollowshipUserModel implements Serializable {

	private long userid;// 用户id，8未
	private String avatar;// 用户头像
	private String name;// 用户名字
	private String gender;// 用户性别，male和female
	private boolean addCard;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isAddCard() {
		return addCard;
	}
	public void setAddCard(boolean addCard) {
		this.addCard = addCard;
	}
	
	
}
