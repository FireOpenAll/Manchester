/**
 * 
 */
package com.galaxy.dal.base.mapper;

import java.io.Serializable;
import java.util.Map;

/**
 * @author luolishu
 * 
 */
public class PaginationParam implements Serializable {

	Map pageData;

	Integer offset=0;

	Integer size=10;

	 

	public Map getPageData() {
		return pageData;
	}

	public void setPageData(Map pageData) {
		this.pageData = pageData;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
