package org.spring.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;

/**
 * 启动类
 *
 * @author dengguoqing
 * @date 2019/4/28
 */
@SpringBootApplication
public class SpringRedisApp {
    public static void main(String[] args) throws MalformedURLException {
        SpringApplication.run(SpringRedisApp.class);
    }


}
