package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年12月2日 下午4:23:02
 *email :hsqmobile@gmail.com
 */
public class ActivityJoinedUser extends BaseDomain {

	private Long userId;
	private String username;
	private Long logicId;
	private Long ticketId;
	private Integer num;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getLogicId() {
		return logicId;
	}

	public void setLogicId(Long logicId) {
		this.logicId = logicId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
