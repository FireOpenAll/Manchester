package com.galaxy.dal.letter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.letter.Letter;

/*author:huangshanqi
 *time  :2014年9月16日 上午12:22:12
 *email :hsqmobile@gmail.com
 */
public interface LetterMapper extends BaseMapper<Letter>{
	
	
	public List<Letter> getToUserLetters(@Param("toUserId")Long userId,@Param("size")Integer size);
	
	public List<Letter> getToUserLettersUtil(@Param("toUserId")Long userId,@Param("letterId")Long utilLetterId,@Param("size")Integer size);
	
	public List<Letter> getFromUserLetters(@Param("fromUserId")Long userId);
 
}
