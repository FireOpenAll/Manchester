package com.lepeng.im.message;

public interface Notification<T> extends Message<T>{
	public Long getToId();
}
