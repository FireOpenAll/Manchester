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
	private boolean following;// userId关注targetId
	private boolean follwoed;// targetId关注 userId

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

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public boolean isFollwoed() {
		return follwoed;
	}

	public void setFollwoed(boolean follwoed) {
		this.follwoed = follwoed;
	}

}
