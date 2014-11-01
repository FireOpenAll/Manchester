package com.galaxy.front.web.rest.model.interest;

import java.io.Serializable;
import java.util.List;

/*author:huangshanqi
 *time  :2014年9月20日 下午4:04:15
 *email :hsqmobile@gmail.com
 */
public class InterestGroup implements Serializable {

	private int count;
	private List<CategoryModel> interests;

	public InterestGroup() {
		super();
	}

	public InterestGroup(int count, List<CategoryModel> interests) {
		super();
		this.count = count;
		this.interests = interests;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CategoryModel> getInterests() {
		return interests;
	}

	public void setInterests(List<CategoryModel> interests) {
		this.interests = interests;
	}

}
