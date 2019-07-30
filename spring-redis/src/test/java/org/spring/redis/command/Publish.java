package org.spring.redis.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * 消息发布
 *
 * @author dengguoqing
 * @date 2019/5/1
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Publish {
    @Autowired
    private RedisTemplate<String,String> template;


    @Test
    public void pub() {
        template.convertAndSend("pub", "message");
        template.multi();
        template.expire("list-key", 1000, TimeUnit.SECONDS);
        template.persist("list-key");

    }

}
