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
	private String remarkName;
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
	public String getRemarkName() {
		return remarkName;
	}
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
	
	
}
