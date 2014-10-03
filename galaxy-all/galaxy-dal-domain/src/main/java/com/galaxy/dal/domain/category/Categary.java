/**
 * 
 */
package com.galaxy.dal.domain.category;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 * 
 */
public class Categary extends BaseDomain {
	String name;
	String text;
	Long parentId;
	String path;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
