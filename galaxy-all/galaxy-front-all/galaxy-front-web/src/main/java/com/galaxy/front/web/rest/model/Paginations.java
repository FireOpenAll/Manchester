package com.galaxy.front.web.rest.model;

import java.io.Serializable;
import java.util.List;

public class Paginations<T extends Serializable>  implements Serializable{
 int pageSize;
 int pageNum;
 List<T> data;
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
public List<T> getData() {
	return data;
}
public void setData(List<T> data) {
	this.data = data;
}

}
