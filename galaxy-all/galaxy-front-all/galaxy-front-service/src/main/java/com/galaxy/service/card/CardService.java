package com.galaxy.service.card;

import com.galaxy.dal.domain.card.Card;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:48:43
 *email :hsqmobile@gmail.com
 */
public interface CardService {
	
	public boolean createCard(Card card);
	public boolean update(Card card);
	public boolean deleteById(Long cardId);
	public Card getById(Long id);
    public Card getByUserId(Long userId);
}
