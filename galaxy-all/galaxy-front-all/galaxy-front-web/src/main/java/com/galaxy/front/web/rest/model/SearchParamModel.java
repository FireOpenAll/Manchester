package com.galaxy.front.web.rest.model;

import java.util.Date;

/*author:huangshanqi
 *time  :2014年10月5日 下午5:47:39
 *email :hsqmobile@gmail.com
 */
public class SearchParamModel {
	/**
	 * 查找接口的param的model
	 */

	private int pageSize;
	private int pageNum;
	private Date start_time;
	private Date end_time;
	private Long category_id;
	private Double longtitude;
	private Double latitude;

	public SearchParamModel() {
		super();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
	//根据查询字符串平凑成SearchParamModel
	public SearchParamModel queryString2SearchParamModel(String queryString){
		SearchParamModel searchParamModel = new SearchParamModel();
		
		
		return searchParamModel;
	}
	

}
