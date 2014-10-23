package com.galaxy.cache.client;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.stereotype.Service;
@Service
public class EhCacheClient<T extends Object>  implements CacheClient<T> {
	@Resource(name="sessionEhCacheManager")
	CacheManager sessionEhCacheManager;
	String cacheName="sessionCache";
	@Override
	public T get(String key) {
		Cache cache=sessionEhCacheManager.getCache(cacheName);
		Element el=cache.get(key);
		if(el==null){
			return null;
		}
		return (T) el.getValue();
	}

	@Override
	public void set(String key, T value) {
		Cache cache=sessionEhCacheManager.getCache(cacheName);
		Element e=new Element(key,value);
		cache.put(e);
	}

	@Override
	public T get(String key, Class<T> type) {
		Cache cache=sessionEhCacheManager.getCache(cacheName);
		Element el=cache.get(key);
		if(el==null){
			return null;
		}
		return (T) el.getValue();
	}

}
