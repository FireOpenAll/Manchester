package com.galaxy.front.web.rest.model.friend;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年12月14日 下午12:06:02
 *email :hsqmobile@gmail.com
 */
public class FriendApplyItemModel implements Serializable {

	private Long targetId;
	private String avatar;
	private String nickName;
	private String applyMessage;
	private boolean addFriend;
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getApplyMessage() {
		return applyMessage;
	}
	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
	}
	public boolean isAddFriend() {
		return addFriend;
	}
	public void setAddFriend(boolean addFriend) {
		this.addFriend = addFriend;
	}
	
	
	
}
