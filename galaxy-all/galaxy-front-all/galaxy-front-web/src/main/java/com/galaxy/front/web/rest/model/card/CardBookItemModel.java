package com.galaxy.front.web.rest.model.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.galaxy.dal.domain.card.Card;

/*author:huangshanqi
 *time  :2014年12月16日 下午8:46:36
 *email :hsqmobile@gmail.com
 */
public class CardBookItemModel implements Serializable {

	private Long userId;
	private String username;// 名字
	private String company;// 公司
	private String title;// 职位
	private String avatar;// 头像URL
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public static CardBookItemModel cardToCardBookItem(Card card){
		if(card == null)
			return null;
		CardBookItemModel item = new CardBookItemModel();
		BeanUtils.copyProperties(card, item);
		return item;
	}
	
	public static ArrayList<CardBookItemModel> cardListToCardBookItemList(List<Card> cards){
		if(cards == null)
			return null;
		ArrayList<CardBookItemModel> result = new ArrayList<CardBookItemModel>();
		for(Card card:cards){
			CardBookItemModel item = new CardBookItemModel();
			if(item != null)
				result.add(item);
		}
		
		return result;
	}
}
