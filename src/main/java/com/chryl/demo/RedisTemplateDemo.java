package com.chryl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 看test测试类
 * <p>
 * Created By Chr on 2019/7/13.
 */
public class RedisTemplateDemo {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
}
