package com.galaxy.front.web.rest.model.interest;

import java.io.Serializable;
import java.util.List;

/*author:huangshanqi
 *time  :2014年9月20日 下午4:04:15
 *email :hsqmobile@gmail.com
 */
public class InterestGroup implements Serializable {

	private int count;
	private List<InterestModel> interests;

	public InterestGroup() {
		super();
	}

	public InterestGroup(int count, List<InterestModel> interests) {
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

	public List<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(List<InterestModel> interests) {
		this.interests = interests;
	}

}
