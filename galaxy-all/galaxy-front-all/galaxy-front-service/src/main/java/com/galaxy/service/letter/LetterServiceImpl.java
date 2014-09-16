package com.galaxy.service.letter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.letter.mapper.LetterMapper;
import com.galaxy.service.letter.LetterService;

/*author:huangshanqi
 *time  :2014年9月16日 上午12:18:43
 *email :hsqmobile@gmail.com
 */
@Service
public class LetterServiceImpl implements LetterService {
	@Autowired
	LetterMapper letterMapper;
	
	

}
