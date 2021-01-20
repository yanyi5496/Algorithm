package com.yanyi.code.sync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author chenqiang
 * @since 2021-01-15 16:28
 */
public class RedisLock {
    @Autowired
    private RedisTemplate redisTemplate;

}
