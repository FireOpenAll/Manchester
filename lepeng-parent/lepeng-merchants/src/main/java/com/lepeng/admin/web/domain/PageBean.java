package com.lepeng.admin.web.domain;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PageBean<T> extends Pageable implements Serializable{


	private Long total = 0l;	//总条数
	private Long pageCount = 0l;//总页数

	private List<T> resultList = null;	//业务数据表

	private int startPage = 1;	//页面显示的初始页
	private int endPage = 1;	//页面显示的截止页
	
	
	public PageBean() {
	}


	public PageBean(Integer pageSize, Integer pageNo) {
		super(pageSize,pageNo);
	}


	public void compute() {
		pageCount = pageSize > 0 ? (Long.valueOf(total.intValue() / pageSize + (total.intValue() % pageSize == 0 ? 0 : 1))) : (total > 0 ? 1 :0); 
		startPage = pageNo > 3 ? pageNo - 3 : 1;
		endPage = (int) (pageCount > startPage + 9 ? startPage + 9 : pageCount);
	}


	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
		compute();
	}

	public List<T> getResultList() {
		return this.resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public int getStartPage() {
		return this.startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return this.endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageCount() {
		return pageCount;
	}

}