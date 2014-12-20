package com.galaxy.dal.domain.card;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年12月2日 下午4:53:33
 *email :hsqmobile@gmail.com
 */
public class UserCard extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9051827963887126698L;
	
	private Long userId;
	private Long targetUserId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
