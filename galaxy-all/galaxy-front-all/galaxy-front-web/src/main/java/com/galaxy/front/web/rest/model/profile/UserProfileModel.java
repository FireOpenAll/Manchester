package com.galaxy.front.web.rest.model.profile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.galaxy.front.web.rest.model.interest.InterestGroup;
import com.galaxy.front.web.rest.model.interest.CategoryModel;
import com.galaxy.front.web.rest.model.location.SimpleAddress;

public class UserProfileModel implements Serializable {

	long user_id;
	String user_name;//昵称
	String avatar;
	String gender;
	Date birthday;

	CreditInfo credit_info;

	SimpleAddress location;

	InterestGroup interest_group;

	int following;
	int followed;

	boolean is_following;
	boolean is_followed;

	int joined_count;
	int like_count;
	int comment_count;
	int create_count;

	public UserProfileModel() {
		super();
	}

	public UserProfileModel(long user_id, String user_name, String avatar, String gender, Date birthday,
			CreditInfo credit_info, SimpleAddress location, InterestGroup interest_group, int following, int followed,
			boolean is_following, boolean is_followed, int joined_count, int like_count, int comment_count,
			int create_count) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.avatar = avatar;
		this.gender = gender;
		this.birthday = birthday;
		this.credit_info = credit_info;
		this.location = location;
		this.interest_group = interest_group;
		this.following = following;
		this.followed = followed;
		this.is_following = is_following;
		this.is_followed = is_followed;
		this.joined_count = joined_count;
		this.like_count = like_count;
		this.comment_count = comment_count;
		this.create_count = create_count;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public CreditInfo getCredit_info() {
		return credit_info;
	}

	public void setCredit_info(CreditInfo credit_info) {
		this.credit_info = credit_info;
	}

	public SimpleAddress getLocation() {
		return location;
	}

	public void setLocation(SimpleAddress location) {
		this.location = location;
	}

	public InterestGroup getInterest_group() {
		return interest_group;
	}

	public void setInterest_group(InterestGroup interest_group) {
		this.interest_group = interest_group;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFollowed() {
		return followed;
	}

	public void setFollowed(int followed) {
		this.followed = followed;
	}

	public boolean isIs_following() {
		return is_following;
	}

	public void setIs_following(boolean is_following) {
		this.is_following = is_following;
	}

	public boolean isIs_followed() {
		return is_followed;
	}

	public void setIs_followed(boolean is_followed) {
		this.is_followed = is_followed;
	}

	public int getJoined_count() {
		return joined_count;
	}

	public void setJoined_count(int joined_count) {
		this.joined_count = joined_count;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getCreate_count() {
		return create_count;
	}

	public void setCreate_count(int create_count) {
		this.create_count = create_count;
	}

	
}
