package com.galaxy.dal.domain.usergroup;

import com.galaxy.dal.domain.BaseDomain;

public class Group extends BaseDomain {

	private Long createUserId;// 创建人员

	private String groupAvatar;// 分组图片头像

	private String name;// 分组名称

	private String domain;// www.alibaba.com,www.qq.com

	private GroupType groupType;// 分组类型

	private String description;// 圈子描述信息

	private int displayType;//0不被搜索，1公开可以搜索到

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getGroupAvatar() {
		return groupAvatar;
	}

	public void setGroupAvatar(String groupAvatar) {
		this.groupAvatar = groupAvatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	 

}
