
package com.galaxy.cache.client;

import java.io.Serializable;

/**
 * @author luolishu
 *
 */
public interface CacheClient<T extends Serializable> {

	T get(String key);
	T get(String key,Class<T> type);
	
	void set(String key,T value);
}
