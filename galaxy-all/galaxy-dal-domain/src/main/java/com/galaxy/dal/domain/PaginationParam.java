package com.galaxy.dal.domain;

import java.io.Serializable;
import java.util.Map;

public class PaginationParam implements Serializable {
	Long utilId;
	Map pageData;

	Long offset=0L;

	Long size=10L;

	public Long getUtilId() {
		return utilId;
	}

	public void setUtilId(Long utilId) {
		this.utilId = utilId;
	}

	public Map getPageData() {
		return pageData;
	}

	public void setPageData(Map pageData) {
		this.pageData = pageData;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	

}
