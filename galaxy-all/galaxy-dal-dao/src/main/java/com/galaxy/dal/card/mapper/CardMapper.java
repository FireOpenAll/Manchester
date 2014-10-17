package com.galaxy.dal.card.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.CardBook;

/*author:huangshanqi
 *time  :2014年10月15日 下午4:47:56
 *email :hsqmobile@gmail.com
 */
public interface CardMapper extends BaseMapper<Card>{
	

	//根据user_id获取他的名片
	public Card getByUserId(@Param("user_id") Long user_id);

	//添加名片到我的名片夹
	public boolean addCardToMyBook(CardBook cardBook);
	
	
	//从我的名片夹删除名片
	public boolean deleteCardFormMyBook(@Param("user_id") Long user_id,@Param("card_id") Long card_id);
	
	//从我的名片本获取名片,分页paginationParam.map.key = {user_id}
	public List<Card> getCradsFromMyBook(PaginationParam paginationParam);
	
	//从我的名片本获取所有名片
	public List<Card> getAllCradsFromMyBook(@Param("user_id") Long user_id);
	
	//查看是否已经添加某人名片
	int checkisAdded(@Param("user_id") long user_id,@Param("target_id") Long target_id);
	int checkisAddedByUserIdCardId(@Param("user_id") long user_id,@Param("card_id") Long card_id);
}
