package com.galaxy.service.activity.form;

import java.io.Serializable;

import com.galaxy.dal.domain.activity.Activity;

public class ActivityForm extends Activity implements Serializable {
    private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    

}
