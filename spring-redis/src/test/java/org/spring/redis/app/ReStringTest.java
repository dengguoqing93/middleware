package org.spring.redis.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2019/4/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReStringTest {

    @Autowired
    ReString reString;

    @Test
    public void addLink() {
        reString.addLink("234", "ret");
    }
}