package com.galaxy.front.web.rest.model.user;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月11日 下午1:31:11
 *email :hsqmobile@gmail.com
 */
public class FollowInfoModel implements Serializable {
	private Long user_id;
	private Long target_id;
	private boolean follow;
	private boolean followed;

	public FollowInfoModel() {
		super();
	}

	public FollowInfoModel(Long user_id, Long target_id, boolean follow, boolean followed) {
		super();
		this.user_id = user_id;
		this.target_id = target_id;
		this.follow = follow;
		this.followed = followed;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getTarget_id() {
		return target_id;
	}

	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public boolean isFollowed() {
		return followed;
	}

	public void setFollowed(boolean followed) {
		this.followed = followed;
	}

}
