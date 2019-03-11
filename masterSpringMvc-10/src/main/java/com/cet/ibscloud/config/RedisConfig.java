package com.cet.ibscloud.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
//@Profile("redis")
@Qualifier("redisTemplate")
public class RedisConfig {

	@Primary
	@Bean
	public CacheManager cacheManager(RedisTemplate template) {
		HashSet h = new HashSet();
		h.add("searches");
		RedisCacheManagerBuilder builder = RedisCacheManagerBuilder
				.fromConnectionFactory(template.getRequiredConnectionFactory());
		builder.initialCacheNames(h);
		return builder.build();
	}

}
