package org.spring.redis.service;

/**
 * 令牌缓存
 *
 * @author dengguoqing
 * @date 2019/4/29
 */
public interface TokenService {
    String checkToken(String token);
}
