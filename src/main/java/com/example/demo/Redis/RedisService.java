package com.example.demo.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Integer value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Integer get(String key) {
        return (Integer) redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public Long decrBy(String key, Integer decrement) {
        return redisTemplate.opsForValue().decrement(key, decrement);
    }

    public Long incrBy(String key, Integer increment) {
        return redisTemplate.opsForValue().increment(key, increment);
    }

    public Integer setIfNotExists(String key, Integer value) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value);
        return success != null?value:get(key);
    }

    public Long decrIfAvailable(String key, Integer value) {
        String script = "local stock_key = KEYS[1] " +
                        "local stock = tonumber(redis.call('GET', stock_key)) " +
                        "local quantity = tonumber(ARGV[1]" +
                        "if stock == nil then return -1 " +
                        "elseif stock < quantity then return -1 " +
                        "else redis.call('DECRBY', stock_key, quantity) return stock - quantity end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        return redisTemplate.execute(redisScript, Collections.singletonList(key), value);
    }

}
