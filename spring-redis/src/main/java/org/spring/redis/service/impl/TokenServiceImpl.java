package org.spring.redis.service.impl;

import org.spring.redis.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author dengguoqing
 * @date 2019/4/29
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override

    public String checkToken(String token) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get("login", token);
    }
}
