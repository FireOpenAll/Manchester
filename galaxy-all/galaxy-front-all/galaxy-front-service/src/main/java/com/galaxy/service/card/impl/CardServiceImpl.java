package com.galaxy.service.card.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.card.mapper.CardMapper;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.service.card.CardService;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:49:44
 *email :hsqmobile@gmail.com
 */
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	CardMapper cardMapper;

	@Override
	public boolean createCard(Card card) {
		// TODO Auto-generated method stub
		Card temp = cardMapper.getByUserId(card.getUserId());
		if (temp != null) {
			return false;
		}
		return cardMapper.insert(card);
	}

	@Override
	public boolean update(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.update(card);
	}

	@Override
	public boolean deleteById(Long cardId) {
		// TODO Auto-generated method stub
		return cardMapper.deleteById(cardId);
	}

	@Override
	public Card getById(Long id) {
		// TODO Auto-generated method stub
		return cardMapper.getById(id);
	}

	@Override
	public Card getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return cardMapper.getByUserId(userId);
	}

}
