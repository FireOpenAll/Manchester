package com.galaxy.dal.domain.user.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.galaxy.dal.domain.user.Gender;

/*author:huangshanqi
 *time  :2014年12月21日 下午1:44:38
 *email :hsqmobile@gmail.com
 */
public class UserProfileForm implements Serializable{

	private Long userId;
	private String tags;
	private String region;
	private Gender gender;
	private String nickName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
}
