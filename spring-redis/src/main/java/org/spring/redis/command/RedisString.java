package org.spring.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 字符串命令使用
 *
 * @author dengguoqing
 * @date 2019/4/29
 */
@Component
public class RedisString {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

}
