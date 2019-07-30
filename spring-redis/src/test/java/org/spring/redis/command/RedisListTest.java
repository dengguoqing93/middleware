package org.spring.redis.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class RedisListTest {

    @Autowired
    private RedisTemplate<String, String> template;
    ListOperations<String, String> operations;
    String key = "list-key";

    @Before
    public void setUp() {
        operations = template.opsForList();
    }

    @Test
    public void push() {
        operations.leftPush(key, "last");
        operations.leftPush(key, "first");
        operations.rightPush(key, "new last");
        List<String> range = operations.range(key, 0, -1);
        assertEquals("列表插入数据", 3, range.size());
        assertEquals("数据尾部", "new last", range.get(2));
        assertEquals("数据头部", "first", range.get(0));
    }

    @Test
    public void pop(){
        operations.trim(key, 0, -1);
        operations.leftPush(key, "last");
        operations.leftPush(key, "first");
        operations.rightPush(key, "new last");
        assertEquals("获取数据1", "first", operations.leftPop(key));
        assertEquals("获取数据2", "last", operations.leftPop(key));
        assertEquals("获取数据3", "new last", operations.rightPop(key));
    }

}