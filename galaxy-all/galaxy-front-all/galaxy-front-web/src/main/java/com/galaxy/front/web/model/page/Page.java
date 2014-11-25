package com.galaxy.front.web.model.page;

import java.util.List;

/*author:huangshanqi
 *time  :2014年11月17日 下午11:29:43
 *email :hsqmobile@gmail.com
 */
public class Page <T> {
	
	private int currentPage;//当前页数
	private int pageSize;//页大小
	private List<T> list;//页内容
	private int totalItem;//总记录条数
	private boolean firstPage;
	private boolean lastPage;
	private boolean hasPre;
	private boolean hasNext;
	
	
	public Page() {
		super();
	}

	public Page(int currentPage,int pageSize,int totalItem) {
		// TODO Auto-generated constructor stub
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalItem = totalItem;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isHasPre() {
		return hasPre;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	
}
