package com.galaxy.front.web.rest.model.card;

import java.io.Serializable;

import com.galaxy.dal.domain.card.Card;

/*author:huangshanqi
 *time  :2014年10月14日 下午9:00:09
 *email :hsqmobile@gmail.com
 */
public class CardModel implements Serializable{
	/* 他人名片的model */
    private Card card;
	private boolean added;// 是否已添加到用户的名片夹

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}
	
	

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getCard().toString()).append(", ");
		stringBuilder.append("added=").append(this.isAdded());
		return stringBuilder.toString();
	}

}
