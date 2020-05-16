package com.live.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 */
public class RedisUtil {

    private String token;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 查询key,支持模糊查询
     *
     * @param key 传过来时key的前后端已经加入了*，或者根据具体处理
     */
    public Set<String> keys(String key) {
        return redisTemplate.keys(key);
    }

    /**
     * 字符串获取值
     *
     * @param key
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 字符串存入值
     * 默认过期时间为2小时
     *
     * @param key
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 7200, TimeUnit.SECONDS);
    }

    /**
     * 字符串存入值
     *
     * @param expire 过期时间（毫秒计）
     * @param key
     */
    public void set(String key, String value, Integer expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }









}
