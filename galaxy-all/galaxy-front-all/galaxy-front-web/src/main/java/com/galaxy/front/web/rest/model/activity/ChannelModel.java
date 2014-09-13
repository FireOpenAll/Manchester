package com.galaxy.front.web.rest.model.activity;

import java.io.Serializable; 

public class ChannelModel  implements Serializable{
	private Long channelId;
	private String title;
	private String picUrl;
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	

}
