package com.galaxy.front.web.rest.model.activity;

import java.io.Serializable;

import com.galaxy.front.web.rest.model.Photo;

public class ChannelModel implements Serializable {
	private Long channelId;
	private String title;
	private Photo cover;
	private String type;

	public ChannelModel() {
		super();
	}

	public ChannelModel(Long channelId, String title, Photo cover, String type) {
		super();
		this.channelId = channelId;
		this.title = title;
		this.cover = cover;
		this.type = type;
	}

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

	public Photo getCover() {
		return cover;
	}

	public void setCover(Photo cover) {
		this.cover = cover;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
