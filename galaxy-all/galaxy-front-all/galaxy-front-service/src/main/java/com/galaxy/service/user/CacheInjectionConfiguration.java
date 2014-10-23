package com.galaxy.service.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.galaxy.cache.client.CacheClient;

@Configuration
public class CacheInjectionConfiguration {
	@Autowired
    private CacheClient<?> sessionCache;

    @PostConstruct
    private void init() {
    	UserUtils.cachedClient=sessionCache;
    }
}
