package com.galaxy.front.web.rest.model.friend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.galaxy.dal.domain.user.User;

/*author:huangshanqi
 *time  :2014年12月14日 上午11:11:09
 *email :hsqmobile@gmail.com
 */
public class ContactsItemModel implements Serializable {
	
	private long userId;// 用户id
	private String avatar;// 用户头像
	private String nickName;// 用户名字
	private String gender;// 用户性别，male和female
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public static ContactsItemModel userToContactsModel(User user){
		if(user == null)
			return null;
		ContactsItemModel model = new ContactsItemModel();
		model.setUserId(user.getId());
		model.setAvatar(user.getAvatar());
		model.setNickName(user.getNick());
		model.setGender(user.getGender().toString());
		return model;
	}
	
	public static ArrayList<ContactsItemModel> userListToContactsList(List<User> users){
		if(users == null)
			return null;
		ArrayList<ContactsItemModel> result = new ArrayList<ContactsItemModel>();
		for(User user:users){
			ContactsItemModel model = userToContactsModel(user);
			if(model!=null)
				result.add(model);
		}
		return result;
		
	}
	
}
