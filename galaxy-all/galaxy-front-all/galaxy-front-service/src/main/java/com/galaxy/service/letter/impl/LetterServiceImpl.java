package com.galaxy.service.letter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.letter.Letter;
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

	@Override
	public boolean post(Letter letter) {
		return letterMapper.insert(letter);
	}

	@Override
	public boolean remove(Long letterId) {
		return letterMapper.deleteById(letterId);
	}

	@Override
	public List<Letter> getToUserLetters(Long userId, Integer size) {
		return letterMapper.getToUserLetters(userId, size);
	}

	@Override
	public List<Letter> getToUserLettersUtil(Long userId, Long utilLetterId,
			Integer size) {
		return letterMapper.getToUserLettersUtil(userId, utilLetterId, size);
	}

	@Override
	public List<Letter> getFromUserLetters(Long userId) {
		return letterMapper.getFromUserLetters(userId);
	}

}
