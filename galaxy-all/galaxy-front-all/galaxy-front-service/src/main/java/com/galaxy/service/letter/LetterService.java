package com.galaxy.service.letter;

import java.util.List;

import com.galaxy.dal.domain.letter.Letter;

/*author:huangshanqi
 *time  :2014年9月16日 上午12:16:57
 *email :hsqmobile@gmail.com
 */
public interface LetterService {

	public boolean post(Letter letter);

	public boolean remove(Long letterId);

	public List<Letter> getToUserLetters(Long userId, Integer size);

	public List<Letter> getToUserLettersUtil(Long userId, Long utilLetterId,
			Integer size);

	public List<Letter> getFromUserLetters(Long userId);
}
