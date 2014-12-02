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
	
	private String nameEn;
	private String nameCh;
	private Long parentId;
	private String path;
	private String coverUrl;
	private String description;public Categary() {
		// TODO Auto-generated constructor stub
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameCh() {
		return nameCh;
	}
	public void setNameCh(String nameCh) {
		this.nameCh = nameCh;
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
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
