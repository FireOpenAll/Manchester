/**
 * 
 */
package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 *
 */
public class ChatGroup extends BaseDomain {
	
	String name;
	Long activityId;
	Long cateId1;
	Long cateId2;
	Long cateId3;
	Long ownerUserId;
	String publicDesc;
	String memberDesc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public String getPublicDesc() {
		return publicDesc;
	}
	public void setPublicDesc(String publicDesc) {
		this.publicDesc = publicDesc;
	}
	public String getMemberDesc() {
		return memberDesc;
	}
	public void setMemberDesc(String memberDesc) {
		this.memberDesc = memberDesc;
	}
	public Long getCateId1() {
		return cateId1;
	}
	public void setCateId1(Long cateId1) {
		this.cateId1 = cateId1;
	}
	public Long getCateId2() {
		return cateId2;
	}
	public void setCateId2(Long cateId2) {
		this.cateId2 = cateId2;
	}
	public Long getCateId3() {
		return cateId3;
	}
	public void setCateId3(Long cateId3) {
		this.cateId3 = cateId3;
	}
	

}
