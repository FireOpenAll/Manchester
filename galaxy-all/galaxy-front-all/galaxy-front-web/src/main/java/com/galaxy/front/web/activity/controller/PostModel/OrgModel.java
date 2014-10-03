package com.galaxy.front.web.activity.controller.PostModel;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月3日 上午10:28:18
 *email :hsqmobile@gmail.com
 */
public class OrgModel implements Serializable {

	//private int id;// 主办方id
	private String name;// 主办方名称
	private String description;// 主办方名称
	private String logo_url;//
	private String type;// ("create")创建状态

	public OrgModel() {
		super();
	}
	
	public OrgModel(String name, String description, String logo_url, String type) {
		super();
		this.name = name;
		this.description = description;
		this.logo_url = logo_url;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sbBuilder = new StringBuilder("");
		sbBuilder.append("name=").append(this.getName()).append(", ");
		sbBuilder.append("description=").append(this.getDescription()).append(", ");
		sbBuilder.append("logo_url=").append(this.getLogo_url()).append(", ");
		sbBuilder.append("type=").append(this.getType());
		
		
		return sbBuilder.toString();
	}

	
}
