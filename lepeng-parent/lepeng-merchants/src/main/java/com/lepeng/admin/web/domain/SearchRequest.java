package com.lepeng.admin.web.domain; 

import java.util.Map;


public class SearchRequest<T> extends Pageable{
	
	/** 要查询的实体. */
	private T queryBean;
	
	/** 其他要查询的参数. */
	private Map<String,Object> queryCondition;

	public SearchRequest(T queryBean) {
		this.queryBean = queryBean;
	}

	public SearchRequest(T queryBean, Map<String,Object> queryCondition) {
		this.queryBean = queryBean;
		this.queryCondition = queryCondition;
	}

	public SearchRequest(T queryBean, int pageSize) {
		this.queryBean = queryBean;
		this.pageSize = pageSize;
	}

	public SearchRequest(T bean, Map<String,Object> queryCondition, int pageSize) {
		this.queryBean = bean;
		this.queryCondition = queryCondition;
		this.pageSize = pageSize;
	}

	public T getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(T queryBean) {
		this.queryBean = queryBean;
	}

	public Map<String, Object> getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(Map<String, Object> queryCondition) {
		this.queryCondition = queryCondition;
	}

	/**
	 * Gets the 开始查询位置.
	 * 
	 * @return the 开始查询位置
	 */
	public int getStart() {
		return pageNo > 1 ? (pageNo -1) * pageSize : 0;
	}
	
}
          
