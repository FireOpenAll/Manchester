/**
 * 
 */
package com.galaxy.dal.domain.account;

import com.galaxy.dal.domain.BaseDomain;

/**
 * 积分表
 * 
 * @author luolishu
 * 
 */
public class Points extends BaseDomain {
	private Long userId;// 用户绑定的账户
	private Long amount;
	private PointStatus status;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public PointStatus getStatus() {
		return status;
	}
	public void setStatus(PointStatus status) {
		this.status = status;
	}
	
	

}
