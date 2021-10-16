package com.pricemonitor.pm_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * @author yzd
 */
@Configuration
public class KeyGeneratorCacheConfig extends CachingConfigurerSupport {

    private final RedisTemplate redisTemplate;

    @Autowired
    public KeyGeneratorCacheConfig(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public CacheManager cacheManager() {
        // 设置key的序列化方式为String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化方式为JSON
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // 设置默认过期时间为600秒
        cacheManager.setDefaultExpiration(600);
        return cacheManager;
    }

    /**
     * key值为className+methodName+参数值列表
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... args) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName()).append("#");
                sb.append(method.getName()).append("(");
                for (Object obj : args) {
                    if(obj != null) {
                        // 在可选参数未给出时时，会出现null，此时需要跳过
                        sb.append(obj.toString()).append(",");
                    }
                }
                sb.append(")");
                return sb.toString();
            }
        };
    }

}