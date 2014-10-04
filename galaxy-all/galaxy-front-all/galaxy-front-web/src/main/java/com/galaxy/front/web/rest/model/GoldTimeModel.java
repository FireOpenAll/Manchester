package com.galaxy.front.web.rest.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2014年10月4日 下午4:07:12
 *email :hsqmobile@gmail.com
 */
public class GoldTimeModel implements Serializable {

	private long gold_time_id;// id
	private Photo icon;// 时段icon
	private String name;// 时段名称

	public GoldTimeModel() {
		super();
	}

	public GoldTimeModel(long gold_time_id, Photo icon, String name) {
		super();
		this.gold_time_id = gold_time_id;
		this.icon = icon;
		this.name = name;
	}

	public long getGold_time_id() {
		return gold_time_id;
	}

	public void setGold_time_id(long gold_time_id) {
		this.gold_time_id = gold_time_id;
	}

	public Photo getIcon() {
		return icon;
	}

	public void setIcon(Photo icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
