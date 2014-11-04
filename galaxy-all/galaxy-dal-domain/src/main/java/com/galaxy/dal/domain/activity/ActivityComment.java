package com.galaxy.dal.domain.activity;

import java.util.Date;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:36:13
 *email :hsqmobile@gmail.com
 */
public class ActivityComment extends BaseDomain {
	//活动评论实体
	
	private Long activityId;//活动id
	private Long userId;//评论人id
	private Long targetId;//回复目标的人id,直接评论活动时=nul
	private Date replyTime;//评论时间，删除修改key 0000-00-00 00:00:00
	private String content;//评论内容
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
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	
	

}
