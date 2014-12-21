package com.galaxy.service.card;

import java.util.ArrayList;
import java.util.List;

import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.UserCard;
import com.galaxy.dal.domain.card.UserCardApply;
import com.galaxy.service.card.form.CardApplyItemForm;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:48:43
 *email :hsqmobile@gmail.com
 */
public interface CardService {
	
	//card
	public boolean createCard(Card card);
	public Card updateCard(Card card);
	public boolean deleteCardById(Long cardId);
	public Card getCardById(Long cardId);
    public Card getCardByUserId(Long userId);
    
    
    
    
    //usercard
    public boolean createUserCard(UserCard userCard);
	public boolean updateUserCard(UserCard userCard);
	public boolean deleteUserCardByUserCardId(Long userCardId);
	public UserCard getUserCardByUserCardId(Long userCardId);
    public boolean deleteCardFromBook(Long userId,Long targetUserId);
    public boolean hasAddCard(Long userId,Long targetUserId);
	public ArrayList<Card> getAllFriendCard(Long userId);
	public List<UserCard> getFriendCardPageByOffset(Long userId,int offset,int pageSize);

	
	//userCardApply
	public boolean createUserCardApply(UserCardApply userCardApply);
	public boolean updateUserCardApply(UserCardApply userCardApply);
	public boolean deleteUserCardApplyById(Long userCardApplyId);
	public boolean hasUserCardApplyExist(Long userId,Long targetUserId);
	public ArrayList<CardApplyItemForm> getAllUserCardApply(Long userId);
	public boolean acceptUserCardApply(UserCard userCard);
}
