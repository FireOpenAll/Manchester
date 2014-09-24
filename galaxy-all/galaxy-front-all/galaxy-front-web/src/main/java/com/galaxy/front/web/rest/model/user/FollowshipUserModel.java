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
	private boolean isFollowed;//主用户被关注
	private boolean isFollowing;//主用户关注该用户
	public FollowshipUserModel() {
		super();
	}
	public FollowshipUserModel(long userid, String avatar, String name, String gender, boolean isFollowed,
			boolean isFollowing) {
		super();
		this.userid = userid;
		this.avatar = avatar;
		this.name = name;
		this.gender = gender;
		this.isFollowed = isFollowed;
		this.isFollowing = isFollowing;
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
	public boolean isFollowed() {
		return isFollowed;
	}
	public void setFollowed(boolean isFollowed) {
		this.isFollowed = isFollowed;
	}
	public boolean isFollowing() {
		return isFollowing;
	}
	public void setFollowing(boolean isFollowing) {
		this.isFollowing = isFollowing;
	}
	
	
}
