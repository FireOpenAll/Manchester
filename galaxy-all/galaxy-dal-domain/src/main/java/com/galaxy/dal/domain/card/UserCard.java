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
	private int requestStatus;//名片请求状态，0=等待同意，1=同意
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
	public int getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
