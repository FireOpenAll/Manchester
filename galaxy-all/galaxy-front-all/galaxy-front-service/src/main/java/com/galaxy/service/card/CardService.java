package com.galaxy.service.card;

import java.util.List;

import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.UserCard;

/*author:huangshanqi
 *time  :2014年12月2日 下午9:48:43
 *email :hsqmobile@gmail.com
 */
public interface CardService {
	
	//card
	public boolean createCard(Card card);
	public boolean updateCard(Card card);
	public boolean deleteCardById(Long cardId);
	public Card getCardById(Long cardId);
    public Card getCardByUserId(Long userId);
    
    
    
    
    //usercard
    public boolean createUserCard(UserCard userCard);
	public boolean updateUserCard(UserCard userCard);
	public boolean deleteUserCardByUserCardId(Long userCardId);
	public UserCard getUserCardByUserCardId(Long userCardId);
    
    public UserCard getByUserIdTargetUserId(Long userId,Long targetUserId);
    public boolean hasAddCard(Long userId,Long targetUserId);
	public List<UserCard> getAllFriendCard(Long userId);
	public List<UserCard> getFriendCardPageByOffset(Long userId,int offset,int pageSize);

    
}
