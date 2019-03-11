package com.cet.ibscloud.config;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.Policy;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

@Configuration
@EnableCaching
public class CacheConfiguration {

//	@Bean
//	public CacheManager cacheManger() {
//		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//		simpleCacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("searches")));
//		return simpleCacheManager;
//	}

	@Bean
	public CacheLoader<Object, Object> cacheLoader() {

		CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {

			@Override
			public Object load(Object key) throws Exception {
				return null;
			}

			// 重写这个方法将oldValue值返回回去，进而刷新缓存
			public ListenableFuture<Object> reload(Object key, Object oldValue) throws Exception {
				return Futures.immediateFuture(oldValue);
			}
		};

		return cacheLoader;
	}
	
	@Bean
	public LoadingCache loadingCache() {

		LoadingCache loadingCache = new LoadingCache() {

			@Override
			public Object getIfPresent(Object key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object get(Object key, Function mappingFunction) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map getAllPresent(Iterable keys) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void put(Object key, Object value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void putAll(Map map) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void invalidate(Object key) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void invalidateAll(Iterable keys) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void invalidateAll() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public long estimatedSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public CacheStats stats() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ConcurrentMap asMap() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void cleanUp() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Policy policy() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object get(Object key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map getAll(Iterable keys) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void refresh(Object key) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return loadingCache;
	}

}
