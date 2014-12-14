package com.galaxy.front.web.rest.model.profile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.galaxy.front.web.rest.model.location.SimpleAddress;

/*author:huangshanqi
 *time  :2014年12月7日 下午12:34:21
 *email :hsqmobile@gmail.com
 */
public class OthersProfileModel implements Serializable {

	/**
	 * 他人的profile Model
	 */
	private Long userId;
	private String nickName;
	private String loginName;
	private List<String> tags;
	private int publishActNum;
	private int joinActNum;
	private int collectActNum;
	private int commentActNum;
	private String avatar;
	private String gender;
	private Date birthday;
	private CreditInfo creditInfo;
	private SimpleAddress address;
	
	private boolean addFriend;
	private boolean addCard;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public int getPublishActNum() {
		return publishActNum;
	}
	public void setPublishActNum(int publishActNum) {
		this.publishActNum = publishActNum;
	}
	public int getJoinActNum() {
		return joinActNum;
	}
	public void setJoinActNum(int joinActNum) {
		this.joinActNum = joinActNum;
	}
	public int getCollectActNum() {
		return collectActNum;
	}
	public void setCollectActNum(int collectActNum) {
		this.collectActNum = collectActNum;
	}
	public int getCommentActNum() {
		return commentActNum;
	}
	public void setCommentActNum(int commentActNum) {
		this.commentActNum = commentActNum;
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
	public CreditInfo getCreditInfo() {
		return creditInfo;
	}
	public void setCreditInfo(CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
	}
	public SimpleAddress getAddress() {
		return address;
	}
	public void setAddress(SimpleAddress address) {
		this.address = address;
	}
	public boolean isAddFriend() {
		return addFriend;
	}
	public void setAddFriend(boolean addFriend) {
		this.addFriend = addFriend;
	}
	public boolean isAddCard() {
		return addCard;
	}
	public void setAddCard(boolean addCard) {
		this.addCard = addCard;
	}
		
}
