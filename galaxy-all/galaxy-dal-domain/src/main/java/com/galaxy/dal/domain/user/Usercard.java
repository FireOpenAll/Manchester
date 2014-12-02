package com.galaxy.dal.domain.user;

import com.galaxy.dal.domain.BaseDomain;
import com.galaxy.dal.domain.card.CardRequestStatus;

/*author:huangshanqi
 *time  :2014年12月2日 下午4:53:33
 *email :hsqmobile@gmail.com
 */
public class Usercard extends BaseDomain{

	private Long userId;
	private Long targetId;
	private Long cardId;
	private CardRequestStatus cardRequestStatus;
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
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	public CardRequestStatus getCardRequestStatus() {
		return cardRequestStatus;
	}
	public void setCardRequestStatus(CardRequestStatus cardRequestStatus) {
		this.cardRequestStatus = cardRequestStatus;
	}

}
