package com.galaxy.service.card;

import java.util.List;

import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.CardBook;

/*author:huangshanqi
 *time  :2014年10月16日 下午12:41:50
 *email :hsqmobile@gmail.com
 */
public interface CardService {
	
	//创建名片
	public boolean createCard(Card card);
	//修改名片
	public boolean modefyCard(Card card);
	//获取名片
	public Card getCardByUserId(Long user_id);
	//添加名片到我的名片夹
	public boolean addCardToMyBook(CardBook cardBook);
	//从我的名片夹删除名片
	public boolean deleteCardFormMyBook(Long user_id,Long card_id);
	
	//从我的名片本获取名片,分页paginationParam.map.key = {user_id}
	public List<Card> getCradsFromMyBook(PaginationParam paginationParam);
	//从我的名片本获取所有名片
	public List<Card> getAllCradsFromMyBook(Long user_id);
	
	//查看是否已经添加某人名片，已添加返回true,两人的user_id
	boolean checkisAdded(long user_id,Long target_id);
	//查看是否已经添加某人名片，已添加返回true,用户的user_id和他人的名片card_id
	boolean checkisAddedByUserIdCardId(Long user_id,Long card_id);
}
