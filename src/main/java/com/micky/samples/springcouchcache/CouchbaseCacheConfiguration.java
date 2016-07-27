package com.micky.samples.springcouchcache;

import com.couchbase.client.java.error.DocumentDoesNotExistException;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CouchbaseCacheConfiguration extends CachingConfigurerSupport {

	@Override
	public CacheErrorHandler errorHandler() {
		return new CouchCacheErrorHandler();
	}

    /**
     * A {@link CacheErrorHandler} that will ignore {@link DocumentDoesNotExistException} on evictions.
     */
	private class CouchCacheErrorHandler extends SimpleCacheErrorHandler {
		@Override
		public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
			if (exception instanceof DocumentDoesNotExistException) {
				//TODO trace?
				//ignore
				return;
			}
			throw exception;
		}
	}
}
