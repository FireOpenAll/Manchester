package com.galaxy.dal.card.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.card.Card;

/*author:huangshanqi
 *time  :2014年10月15日 下午4:47:56
 *email :hsqmobile@gmail.com
 */
public interface CardMapper extends BaseMapper<Card>{
	

	//根据user_id获取他的名片
	public Card getByUserId(@Param("userId") Long userId);

}
