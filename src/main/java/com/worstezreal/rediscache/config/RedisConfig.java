package com.worstezreal.rediscache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/8/17
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        Map<String, Long> expires = new HashMap<>();
        expires.put("city_config", 60L * 30L);
        redisCacheManager.setExpires(expires);
        return redisCacheManager;
    }


    @Bean(name = "methodKeyGenerator")
    public KeyGenerator firstParamKeyGenerator(){
        return (target, method, params) -> method.getName();
    }
}
