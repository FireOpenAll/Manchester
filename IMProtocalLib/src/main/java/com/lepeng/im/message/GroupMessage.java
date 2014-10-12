/**
 * 
 */
package com.lepeng.im.message;

/**
 * @author luolishu
 * 
 */
public interface GroupMessage<T> extends Message<T> {
	public Long getGroupId();

	public Long getFromId();
}
