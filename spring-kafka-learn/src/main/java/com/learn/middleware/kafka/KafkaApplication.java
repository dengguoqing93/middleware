/*
package com.learn.middleware.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

*/
/**
 * kafka服务启动类
 *
 * @author dengguoqing
 * @date 2019/5/6
 *//*

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {


    public static Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args).close();
    }

    @Autowired
    private KafkaTemplate<String,String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        this.template.sendDefault("foo7");
        this.template.sendDefault("foo8");
        this.template.sendDefault("foo9");
        latch.await(10, TimeUnit.SECONDS);
        logger.info("All received");
    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
        latch.countDown();
    }

}
*/
