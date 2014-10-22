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
	private int relation;// default 0 = 无关系，1=关注，2=被关注，3=互粉

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

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}

}
