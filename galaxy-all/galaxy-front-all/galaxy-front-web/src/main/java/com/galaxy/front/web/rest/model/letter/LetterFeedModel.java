package com.galaxy.front.web.rest.model.letter;

import java.io.Serializable;

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

	public static class UserModel {
		/*
		 * user { user_id: XXXXX, avatar: XXXXXX, name: XXXXX, gender:
		 * XXXXX,0为男，1为女 }
		 */

		private long userid;// 用户id，8未
		private String avatar;// 用户头像
		private String name;// 用户名字
		private String gender;// 用户性别，male和female

		public UserModel() {
			super();
		}

		public UserModel(long userid, String avatar, String name, String gender) {
			super();
			this.userid = userid;
			this.avatar = avatar;
			this.name = name;
			this.gender = gender;
		}

		public long getUserid() {
			return userid;
		}

		public void setUserid(long userid) {
			this.userid = userid;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

	}

}
