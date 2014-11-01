package com.galaxy.front.web.rest.model.interest;

import java.io.Serializable;
import java.util.ArrayList;

import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.activity.ActivityModel;
import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年9月27日 下午12:17:53
 *email :hsqmobile@gmail.com
 */
public class InterestDetailModel implements Serializable {
	/**
	 * 兴趣详细类
	 */
	private long interest_id;
	private String interest_name;
	private Photo cover;// 活动封面
	private String description;// 兴趣描述
	private int activity_count;// 兴趣包含活动数
	private int member_count;// 兴趣内人数
	private ArrayList<UserModel> recomment_user;// 推荐用户
	private ArrayList<CategoryModel> relative_interest;// 与之相关的兴趣

	public InterestDetailModel() {
		super();
	}

	public InterestDetailModel(long interest_id, String interest_name, Photo cover, String description,
			int activity_count, int member_count, ArrayList<UserModel> recomment_user,
			ArrayList<CategoryModel> relative_interest) {
		super();
		this.interest_id = interest_id;
		this.interest_name = interest_name;
		this.cover = cover;
		this.description = description;
		this.activity_count = activity_count;
		this.member_count = member_count;
		this.recomment_user = recomment_user;
		this.relative_interest = relative_interest;
	}

	public long getInterest_id() {
		return interest_id;
	}

	public void setInterest_id(long interest_id) {
		this.interest_id = interest_id;
	}

	public String getInterest_name() {
		return interest_name;
	}

	public void setInterest_name(String interest_name) {
		this.interest_name = interest_name;
	}

	public Photo getCover() {
		return cover;
	}

	public void setCover(Photo cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActivity_count() {
		return activity_count;
	}

	public void setActivity_count(int activity_count) {
		this.activity_count = activity_count;
	}

	public int getMember_count() {
		return member_count;
	}

	public void setMember_count(int member_count) {
		this.member_count = member_count;
	}

	public ArrayList<UserModel> getRecomment_user() {
		return recomment_user;
	}

	public void setRecomment_user(ArrayList<UserModel> recomment_user) {
		this.recomment_user = recomment_user;
	}

	public ArrayList<CategoryModel> getRelative_interest() {
		return relative_interest;
	}

	public void setRelative_interest(ArrayList<CategoryModel> relative_interest) {
		this.relative_interest = relative_interest;
	}

}
