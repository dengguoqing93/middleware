package com.learn.middleware.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic配置
 *
 * @author dengguoqing
 * @date 2019/5/13
 */
@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic topic1(){
        return new NewTopic("thing1", 10, (short) 2);
    }

    @Bean
    public NewTopic topic2(){
        return new NewTopic("thing1", 10, (short) 2);
    }

}
