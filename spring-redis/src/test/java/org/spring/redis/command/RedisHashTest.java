package org.spring.redis.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * redis字符串命令测试
 *
 * @author dengguoqing
 * @date 2019/4/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisHashTest {

    @Autowired
    private RedisTemplate<String, String> template;
    HashOperations<String, String,String> operations;
    String key = "hash-key";

    @Before
    public void setUp() {
        operations = template.opsForHash();
    }

    @Test
    public void push() {
        operations.put(key, "k1", "v1");
        String k1 = operations.get(key, "k1");
        System.out.println(k1);


    }

    @Test
    public void pop(){

    }

}