package com.galaxy.service.card.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.card.mapper.CardMapper;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.CardBook;
import com.galaxy.service.card.CardService;

/*author:huangshanqi
 *time  :2014年10月16日 下午12:43:14
 *email :hsqmobile@gmail.com
 */
@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardMapper cardMapper;
	
	@Override
	public boolean createCard(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.insert(card);
	}

	@Override
	public boolean modefyCard(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.update(card);
	}

	@Override
	public Card getCardByUserId(Long user_id) {
		// TODO Auto-generated method stub
		return cardMapper.getByUserId(user_id);
	}

	@Override
	public boolean addCardToMyBook(CardBook cardBook) {
		// TODO Auto-generated method stub
		return cardMapper.addCardToMyBook(cardBook);
	}

	@Override
	public boolean deleteCardFormMyBook(Long user_id, Long card_id) {
		// TODO Auto-generated method stub
		return cardMapper.deleteCardFormMyBook(user_id, card_id);
	}

	@Override
	public List<Card> getCradsFromMyBook(PaginationParam paginationParam) {
		// TODO Auto-generated method stub
		return cardMapper.getCradsFromMyBook(paginationParam);
	}

	@Override
	public ArrayList<Card> getAllCradsFromMyBook(Long user_id) {
		// TODO Auto-generated method stub
		return cardMapper.getAllCradsFromMyBook(user_id);
	}

	@Override
	public boolean checkisAdded(long user_id, Long target_id) {
		// TODO Auto-generated method stub
		return (cardMapper.checkisAdded(user_id, target_id)>0)?true:false;
	}

	@Override
	public boolean checkisAddedByUserIdCardId(Long user_id, Long card_id) {
		// TODO Auto-generated method stub
		return (cardMapper.checkisAddedByUserIdCardId(user_id, card_id)>0)?true:false;
	}
	
	

}
