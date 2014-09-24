package com.galaxy.front.web.rest.model;

import java.io.Serializable;
import java.util.List;

/*author:huangshanqi
 *time  :2014年9月21日 下午5:31:08
 *email :hsqmobile@gmail.com
 */
public class ListModel<T extends Serializable> implements Serializable {

	private int count;
	private List<T> list;

	public ListModel() {
		super();
	}

	public ListModel(int count, List<T> list) {
		super();
		this.count = count;
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
