package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:36:13
 *email :hsqmobile@gmail.com
 */
public class ActivityComment extends BaseDomain {
	// 活动评论实体
	private static final long serialVersionUID = 3717258542236267037L;
	
	private Long activityId;
	private Long userId;// 评论人id
	private Long targetId;// 回复目标的人id,直接评论活动时=null
	private Integer commentType;//0=评论活动，1=评论他人的评论
	private String content;// 评论内容
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
	public Integer getCommentType() {
		return commentType;
	}
	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	

}
