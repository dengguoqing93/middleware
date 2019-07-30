package org.spring.redis.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class RedisStringTest {

    @Autowired
    private RedisTemplate<String, String> template;
    ValueOperations<String, String> stringOperations;

    @Before
    public void setUp() {
        stringOperations = template.opsForValue();
    }

    @Test
    public void testString() {
        stringOperations.set("key", "12");
        stringOperations.increment("key");
        assertEquals("字符串自增", "13", stringOperations.get("key"));
        stringOperations.increment("key", 12);
        assertTrue("数字类字符串指定长度增长", "25".equals(stringOperations.get("key")));

        stringOperations.set("key", "12");
        stringOperations.decrement("key", 12);
        assertEquals("数字类字符串按指定值减少", "0", stringOperations.get("key"));
    }

    @Test
    public void testAppend() {
        stringOperations.set("key", "hello ");
        stringOperations.append("key", "world");
        assertEquals("append命令测试", "hello world", stringOperations.get("key"));
        assertEquals("getRange命令测试", "hello", stringOperations.get("key", 0, 4));
        stringOperations.set("key", "worl", 0);
        assertEquals("替换命令", "worl", stringOperations.get("key", 0, 3));
    }
    @Test
    public void testBit(){
        stringOperations.set("key", "hello ");
        Boolean value = stringOperations.getBit("key", 10);
        System.out.println(value);

    }

}