package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:36:13
 *email :hsqmobile@gmail.com
 */
public class ActivityComment extends BaseDomain {
	// 活动评论实体

	/**
	 * 
	 */
	private static final long serialVersionUID = 3717258542236267037L;
	
	private Long userId;// 评论人id
	private Long targetId;// 回复目标的人id,直接评论活动时
	private ActivityReplyType replyType;
	private String content;// 评论内容

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

	public ActivityReplyType getReplyType() {
		return replyType;
	}

	public void setReplyType(ActivityReplyType replyType) {
		this.replyType = replyType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
