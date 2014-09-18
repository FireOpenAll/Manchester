package com.galaxy.front.web.rest.model.letter;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2014年9月15日 下午11:59:30
 *email :hsqmobile@gmail.com
 */
public class LetterModel implements Serializable{

	/*
	 * letter { id: XXXX, content: XXXXXX, time: XXXXX, from: XXXXXX, to:XXXX }
	 */
	private long id;// 私信id，8未
	private String content;// 私信内容
	private Date time;// 私信发送时间
	private long from;// 私信发送者,8位
	private long to;// 私信接收者

	public LetterModel() {
		super();
	}

	public LetterModel(long id, String content, Date time, long from, long to) {
		super();
		this.id = id;
		this.content = content;
		this.time = time;
		this.from = from;
		this.to = to;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

}
