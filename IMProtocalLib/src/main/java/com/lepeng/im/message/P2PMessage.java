package com.lepeng.im.message;

public interface P2PMessage<T> extends Message<T> {
	public Long getToId();

	public Long getFromId();
}
