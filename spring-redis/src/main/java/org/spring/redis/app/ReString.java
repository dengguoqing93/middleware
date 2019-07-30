package org.spring.redis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis中string的使用
 *
 * @author dengguoqing
 * @date 2019/4/25
 */
@Service
public class ReString {
    @Autowired
    private RedisTemplate<String, String> template;

    public void addLink(String userId, String url) {
        ListOperations<String, String> listOperations = template.opsForList();
        listOperations.leftPush(userId, url);
    }
}
