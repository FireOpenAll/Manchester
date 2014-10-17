package com.galaxy.dal.domain.card;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2014年10月18日 上午12:28:58
 *email :hsqmobile@gmail.com
 */
public class CardBook implements Serializable {

	private Long id;
	private Date created_time;
	private Long user_id;
	private Long card_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getCard_id() {
		return card_id;
	}

	public void setCard_id(Long card_id) {
		this.card_id = card_id;
	}

}
