package com.galaxy.front.web.rest.model.user;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月21日 下午5:09:38
 *email :hsqmobile@gmail.com
 */
public class UserModel implements Serializable {

	/*
	 * user { user_id: XXXXX, avatar: XXXXXX, name: XXXXX, gender: XXXXX,0为男，1为女
	 * }
	 */

	private long userid;// 用户id，8未
	private String avatar;// 用户头像
	private String name;// 用户名字
	private String gender;// 用户性别，male和female

	public UserModel() {
		super();
	}

	public UserModel(long userid, String avatar, String name, String gender) {
		super();
		this.userid = userid;
		this.avatar = avatar;
		this.name = name;
		this.gender = gender;
	}

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

}