/**
 * 
 */
package com.galaxy.dal.domain.chat;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 *
 */
public class ChatCategory  extends BaseDomain{
    Long parentId;
    String path;
	String text;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
