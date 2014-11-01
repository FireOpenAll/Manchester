package com.lepeng.im.message;

import java.util.Map;

public interface Message<T> {
	public Long getMessageId();

	public Message<?> decode(T payload);
	/**
	 * 
	 * @param values json Map
	 * @return
	 */
	public Message<?> decode(Map<?, ?> values);

	public T encode();

	public Integer getMessageType();

	public String getContent();

}
