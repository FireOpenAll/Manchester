package com.galaxy.front.web.rest.model;

import java.io.Serializable;
import java.util.List;

public class Paginations<T extends Serializable>  implements Serializable{
 int pageSize;
 int pageNum;
 int tatal;
 List<T> datas;
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
public int getTatal() {
	return tatal;
}
public void setTatal(int tatal) {
	this.tatal = tatal;
}
public List<T> getDatas() {
	return datas;
}
public void setDatas(List<T> datas) {
	this.datas = datas;
} 
 
}
