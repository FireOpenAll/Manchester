/**
 * 
 */
package com.galaxy.dal.domain.paper;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 *
 */
public class Question extends BaseDomain{
	Long paperId;
	QuestionType type;
	String content;
	public Long getPaperId() {
		return paperId;
	}
	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
