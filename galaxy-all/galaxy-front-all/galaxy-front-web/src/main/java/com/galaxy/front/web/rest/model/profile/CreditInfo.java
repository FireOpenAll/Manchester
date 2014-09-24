package com.galaxy.front.web.rest.model.profile;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月20日 下午4:11:24
 *email :hsqmobile@gmail.com
 */
public class CreditInfo implements Serializable {

	private int level;
	private String name;

	public CreditInfo() {
		super();
	}

	public CreditInfo(int level, String name) {
		super();
		this.level = level;
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
