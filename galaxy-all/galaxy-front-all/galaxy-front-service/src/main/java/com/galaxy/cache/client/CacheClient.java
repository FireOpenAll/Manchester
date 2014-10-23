
package com.galaxy.cache.client;


/**
 * @author luolishu
 *
 */
public interface CacheClient<T extends Object> {

	T get(String key);
	T get(String key,Class<T> type);
	
	void set(String key,T value);
}
