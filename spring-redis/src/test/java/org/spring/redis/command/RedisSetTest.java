package org.spring.redis.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * redis字符串命令测试
 *
 * @author dengguoqing
 * @date 2019/4/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisSetTest {

    @Autowired
    private RedisTemplate<String, String> template;
    SetOperations<String, String> operations;
    String key = "list-key";

    @Before
    public void setUp() {
        operations = template.opsForSet();
    }

    @Test
    public void push() {
        operations.pop("set-key",3);
        String key = "set-key";
        Long add = operations.add(key, "a", "b", "c");
        assertTrue("向集合添加三个元素", 3 == add);
        Long remove = operations.remove(key, "c", "d");
        assertTrue("从集合中删除一个元素", 1 == remove);
        Long size = operations.size(key);
        assertTrue("集合中剩余元素数量", 2 == size);
        Set<String> members = operations.members(key);
        assertTrue("集合中的元素", members.contains("a") && members.contains("b"));
        Boolean bool = operations.move(key, "a", "set-key2");
        System.out.println(bool);
    }

    @Test
    public void pop() {

    }

}