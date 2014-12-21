package com.galaxy.front.web.rest.model.comment;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.galaxy.dal.domain.activity.ActivityComment;

/*author:huangshanqi
 *time  :2014年12月16日 下午3:10:27
 *email :hsqmobile@gmail.com
 */
public class CommentModel implements Serializable {

	
	private Long id;
	private Long activityId;
	private Long userId;
	private String nickName;
	private String avatar;
	private String content;
	private Date time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public static CommentModel activityCommentToCommentModel(ActivityComment comment){
		CommentModel result = new CommentModel();
		BeanUtils.copyProperties(comment, result);
		
		return result;
	}
}
