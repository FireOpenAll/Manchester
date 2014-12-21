package com.lepeng.admin.web.domain; 


public class Pageable {

	/**  每页显示的数量. */
	protected Integer pageSize;
	
	/**  当前页码. */
	protected Integer pageNo;
	
	public Pageable() {
		pageSize = 10;
		pageNo = 1;
	}

	public Pageable(Integer pageNo, Integer pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	/**
	 * Gets the 每页显示的数量.
	 * 
	 * @return the 每页显示的数量
	 */
	public Integer getPageSize() {
		return pageSize;
	}


	/**
	 * Sets the 每页显示的数量.
	 * 
	 * @param pageSize
	 *            the new 每页显示的数量
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * Gets the 当前页码.
	 * 
	 * @return the 当前页码
	 */
	public Integer getPageNo() {
		return pageNo;
	}


	/**
	 * Sets the 当前页码.
	 * 
	 * @param pageNo
	 *            the new 当前页码
	 */
	public void setPageNo(Integer pageNo) {
		if (pageNo == null) {
			this.pageNo = 1;
		}else {
			this.pageNo = pageNo;
		}
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