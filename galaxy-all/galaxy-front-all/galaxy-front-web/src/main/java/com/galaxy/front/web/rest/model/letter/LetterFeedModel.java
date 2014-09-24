package com.galaxy.front.web.rest.model.letter;

import java.io.Serializable;

import com.galaxy.front.web.rest.model.user.UserModel;

/*author:huangshanqi
 *time  :2014年9月16日 上午12:00:30
 *email :hsqmobile@gmail.com
 */
public class LetterFeedModel implements Serializable {
	/*
	 * letter_feed { unread: XX, count: XX, target: {user} last_letter: {letter}
	 * }
	 */
	private int unread;// 未读私信数目
	private int count;// 总共私信数目
	private UserModel target;// 内部类,用户类
	private LetterModel lastLetter;// 私信类,最后一条私信

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserModel getTarget() {
		return target;
	}

	public void setTarget(UserModel target) {
		this.target = target;
	}

	public LetterModel getLastLetter() {
		return lastLetter;
	}

	public void setLastLetter(LetterModel lastLetter) {
		this.lastLetter = lastLetter;
	}


}
