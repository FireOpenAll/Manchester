package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年10月22日 上午12:19:51
 *email :hsqmobile@gmail.com
 */
public class UserFriend extends BaseDomain {
	// 用户关系实体
	private Long userId;
	private Long targetId;
	private UserFriendRequestStatus requestStatus;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public UserFriendRequestStatus getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(UserFriendRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

}
