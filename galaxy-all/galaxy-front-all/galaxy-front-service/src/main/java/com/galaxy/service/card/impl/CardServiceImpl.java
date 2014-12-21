package com.galaxy.service.card.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.card.mapper.CardMapper;
import com.galaxy.dal.card.mapper.UserCardApplyMapper;
import com.galaxy.dal.card.mapper.UserCardMapper;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.UserCard;
import com.galaxy.dal.domain.card.UserCardApply;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.card.CardService;
import com.galaxy.service.card.form.CardApplyItemForm;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:49:44
 *email :hsqmobile@gmail.com
 */
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardMapper cardMapper;
	@Autowired
	private UserCardMapper userCardMapper;
	@Autowired
	private UserCardApplyMapper userCardApplyMapper;

	@Transactional
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
	public boolean updateCard(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.update(card);
	}

	@Override
	public boolean deleteCardById(Long cardId) {
		// TODO Auto-generated method stub
		return cardMapper.deleteById(cardId);
	}

	@Override
	public Card getCardById(Long cardId) {
		// TODO Auto-generated method stub
		return cardMapper.getById(cardId);
	}

	@Override
	public Card getCardByUserId(Long userId) {
		// TODO Auto-generated method stub
		return cardMapper.getByUserId(userId);
	}

	
	
	@Override
	@Transactional
	public boolean createUserCard(UserCard userCard) {
		// TODO Auto-generated method stub
		UserCard temp = userCardMapper.getByUserIdTargetUserId(userCard.getUserId(), userCard.getTargetUserId());
		if(temp == null){
			return userCardMapper.insert(userCard);
		}
		return false;
	}

	@Override
	public boolean updateUserCard(UserCard userCard) {
		// TODO Auto-generated method stub
		return userCardMapper.update(userCard);
	}

	@Override
	public boolean deleteCardFromBook(Long userId, Long targetUserId) {
		// TODO Auto-generated method stub
		
		UserCardApply temp = userCardApplyMapper.getUserCardApply(targetUserId,userId);
		if(temp != null){
			temp.setUpdatedTime(new Date());
		    temp.setApplyStatus(0);
		    userCardApplyMapper.update(temp);
		}
		return userCardMapper.deleteByUserIdTargetId(userId, targetUserId);
	}

	@Override
	public boolean deleteUserCardByUserCardId(Long userCardId) {
		// TODO Auto-generated method stub
		return userCardMapper.deleteById(userCardId);
	}

	@Override
	public UserCard getUserCardByUserCardId(Long userCardId) {
		// TODO Auto-generated method stub
		return userCardMapper.getById(userCardId);
	}
	
	@Transactional
	@Override
	public List<Card> getAllFriendCard(Long userId) {
		// TODO Auto-generated method stub
		List<UserCard> list = userCardMapper.getAllFriendCard(userId);
		if(list == null)
			return null;
		List<Card> cards = new ArrayList<Card>();
		for(UserCard userCard:list){
			Card card = cardMapper.getByUserId(userCard.getTargetUserId());
			cards.add(card);
		}
		return cards;
	}

	@Override
	public List<UserCard> getFriendCardPageByOffset(Long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return userCardMapper.getFriendCardPageByOffset(userId, offset, pageSize);
	}


	@Override
	public boolean hasAddCard(Long userId, Long targetUserId) {
		// TODO Auto-generated method stub
		UserCard temp = userCardMapper.getByUserIdTargetUserId(userId, targetUserId);
		return temp != null;
	}

	@Override
	@Transactional
	public boolean createUserCardApply(UserCardApply userCardApply) {
		// TODO Auto-generated method stub
		UserCardApply temp = userCardApplyMapper.getUserCardApply(userCardApply.getUserId(), userCardApply.getTargetId());
		
		if(temp != null){
			return  true;
		}
		return userCardApplyMapper.insert(userCardApply);
	}

	@Override
	public boolean updateUserCardApply(UserCardApply userCardApply) {
		// TODO Auto-generated method stub
		
		return userCardApplyMapper.update(userCardApply);
	}

	@Override
	public boolean deleteUserCardApplyById(Long userCardApplyId) {
		// TODO Auto-generated method stub
		return userCardApplyMapper.deleteById(userCardApplyId);
	}

	@Override
	public boolean hasUserCardApplyExist(Long userId, Long targetUserId) {
		// TODO Auto-generated method stub
		UserCardApply temp = userCardApplyMapper.getUserCardApply(userId, targetUserId);
		return temp != null;
	}

	@Transactional
	@Override
	public ArrayList<CardApplyItemForm> getAllUserCardApply(Long userId) {
		// TODO Auto-generated method stub
		List<UserCardApply> list = userCardApplyMapper.getAllCardApply(userId);
		if(list == null)
			return null;
		ArrayList<CardApplyItemForm> applys = new ArrayList<CardApplyItemForm>();
		for(UserCardApply apply : list){
			Card card = cardMapper.getByUserId(apply.getUserId());
			if(card != null){
				CardApplyItemForm item = new CardApplyItemForm();
				BeanUtils.copyProperties(card, item);
				item.setAddCard(apply.getApplyStatus()==1);
				applys.add(item);
		    }
		}
		return applys;
		
	}

	@Override
	public boolean acceptUserCardApply(UserCard userCard) {
		// TODO Auto-generated method stub
		UserCardApply apply = userCardApplyMapper.getUserCardApply(userCard.getTargetUserId(),userCard.getUserId());
		if(apply == null)
			return false;
		if(apply.getApplyStatus() == 1)
			return false;
		if(!hasAddCard(userCard.getUserId(), userCard.getTargetUserId())){
			userCardMapper.insert(userCard);
		}
		
		if(!hasAddCard( userCard.getTargetUserId(),userCard.getUserId())){
			UserCard to = new UserCard();
			to.setCreatedTime(userCard.getCreatedTime());
			to.setUpdatedTime(userCard.getUpdatedTime());
			to.setUserId(userCard.getTargetUserId());
			to.setTargetUserId(userCard.getUserId());
		    userCardMapper.insert(to);
		}	
		apply.setUpdatedTime(new Date());
		apply.setApplyStatus(1);
		return userCardApplyMapper.update(apply);
	}
	
	
	
	



}
