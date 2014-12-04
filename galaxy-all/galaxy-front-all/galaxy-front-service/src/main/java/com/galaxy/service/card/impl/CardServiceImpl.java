package com.galaxy.service.card.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.card.mapper.CardMapper;
import com.galaxy.dal.card.mapper.UserCardMapper;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.UserCard;
import com.galaxy.dal.user.mapper.UserMapper;
import com.galaxy.service.card.CardService;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:49:44
 *email :hsqmobile@gmail.com
 */
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	CardMapper cardMapper;
	@Autowired
	private UserCardMapper userCardMapper;

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
	public boolean deleteUserCardByUserCardId(Long userCardId) {
		// TODO Auto-generated method stub
		return userCardMapper.deleteById(userCardId);
	}

	@Override
	public UserCard getUserCardByUserCardId(Long userCardId) {
		// TODO Auto-generated method stub
		return userCardMapper.getById(userCardId);
	}
	
	@Override
	public List<UserCard> getAllFriendCard(Long userId) {
		// TODO Auto-generated method stub
		return userCardMapper.getAllFriendCard(userId);
	}

	@Override
	public List<UserCard> getFriendCardPageByOffset(Long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return userCardMapper.getFriendCardPageByOffset(userId, offset, pageSize);
	}

	@Override
	public UserCard getByUserIdTargetUserId(Long userId, Long targetUserId) {
		// TODO Auto-generated method stub
		return userCardMapper.getByUserIdTargetUserId(userId, targetUserId);
	}



}
