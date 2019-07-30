package com.learn.middleware.kafka.config;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * kafka监听器
 *
 * @author dengguoqing
 * @date 2019/5/13
 */
public class Listener {
    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "0", topics = "annotated1")
    public void listen1(String foo) {
        this.latch1.countDown();
    }
}
