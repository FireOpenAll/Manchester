package com.galaxy.front.web.rest.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年9月27日 上午11:39:50
 *email :hsqmobile@gmail.com
 */
public class Photo implements Serializable {
	/**
	 * 照片类,客户端的尺寸适配
	 */

	private String small;
	private String meduim;
	private String large;

	public Photo() {
		super();
	}

	public Photo(String small, String meduim, String large) {
		super();
		this.small = small;
		this.meduim = meduim;
		this.large = large;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getMeduim() {
		return meduim;
	}

	public void setMeduim(String meduim) {
		this.meduim = meduim;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

}
