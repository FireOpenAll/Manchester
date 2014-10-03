package com.galaxy.front.web.rest.model;

import java.io.Serializable;
import java.util.Date;

import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年10月3日 下午2:59:59
 *email :hsqmobile@gmail.com
 */
public class CommentModel implements Serializable {
	private long commend_id;
	private UserModel author;
	private String content;
	private Date create_time;

	public CommentModel() {
		super();
	}

	public CommentModel(long commend_id, UserModel author, String content, Date create_time) {
		super();
		this.commend_id = commend_id;
		this.author = author;
		this.content = content;
		this.create_time = create_time;
	}

	public long getCommend_id() {
		return commend_id;
	}

	public void setCommend_id(long commend_id) {
		this.commend_id = commend_id;
	}

	public UserModel getAuthor() {
		return author;
	}

	public void setAuthor(UserModel author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
