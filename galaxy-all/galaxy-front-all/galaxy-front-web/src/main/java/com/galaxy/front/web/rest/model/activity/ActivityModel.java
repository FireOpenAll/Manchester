package com.galaxy.front.web.rest.model.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.galaxy.front.web.rest.model.Contact;
import com.galaxy.front.web.rest.model.Photo;
import com.galaxy.front.web.rest.model.interest.CategoryModel;
import com.galaxy.front.web.rest.model.location.LocationInfo;
import com.galaxy.front.web.rest.model.user.UserModel;

public class ActivityModel implements Serializable {

	private String feed_type;// feedItem类型

	private Long activity_id;
	private String activity_name;
	private float price;
	private boolean like;// 是否已经点击喜欢
	private int like_count;// 点赞人数
	private boolean join;// 是否已经点击参加
	private int join_count;// 参加人数
	private int comment_count;// 评论数
	private String owner;// 组织者
	private Date start_time;
	private Date end_time;
	private Contact contact;// 联系方式
	private String summary;// 活动摘要信息
	private String url;// 活动详情url
	private ArrayList<Photo> photo_list;// 活动照片
	private LocationInfo locationInfo;// 活动地点
	private ArrayList<UserModel> relative_user;// 活动相关参与人员
	private ArrayList<CategoryModel> interest_list;// 活动相关兴趣

	public ActivityModel() {
		super();
	}

	public ActivityModel(String feed_type, Long activity_id, String activity_name, float price, boolean like,
			int like_count, boolean join, int join_count, int comment_count, String owner, Date start_time,
			Date end_time, Contact contact, String summary, String url, ArrayList<Photo> photo_list,
			LocationInfo locationInfo, ArrayList<UserModel> relative_user, ArrayList<CategoryModel> interest_list) {
		super();
		this.feed_type = feed_type;
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.price = price;
		this.like = like;
		this.like_count = like_count;
		this.join = join;
		this.join_count = join_count;
		this.comment_count = comment_count;
		this.owner = owner;
		this.start_time = start_time;
		this.end_time = end_time;
		this.contact = contact;
		this.summary = summary;
		this.url = url;
		this.photo_list = photo_list;
		this.locationInfo = locationInfo;
		this.relative_user = relative_user;
		this.interest_list = interest_list;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public String getFeed_type() {
		return feed_type;
	}

	public void setFeed_type(String feed_type) {
		this.feed_type = feed_type;
	}

	public Long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Long activity_id) {
		this.activity_id = activity_id;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public boolean isJoin() {
		return join;
	}

	public void setJoin(boolean join) {
		this.join = join;
	}

	public int getJoin_count() {
		return join_count;
	}

	public void setJoin_count(int join_count) {
		this.join_count = join_count;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<Photo> getPhoto_list() {
		return photo_list;
	}

	public void setPhoto_list(ArrayList<Photo> photo_list) {
		this.photo_list = photo_list;
	}

	public LocationInfo getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}

	public ArrayList<UserModel> getRelative_user() {
		return relative_user;
	}

	public void setRelative_user(ArrayList<UserModel> relative_user) {
		this.relative_user = relative_user;
	}

	public ArrayList<CategoryModel> getInterest_list() {
		return interest_list;
	}

	public void setInterest_list(ArrayList<CategoryModel> interest_list) {
		this.interest_list = interest_list;
	}

}
