package com.learn.middleware.kafka.cliet;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 第一个消费者
 *
 * @author dengguoqing
 * @date 2019/8/24
 */
public class Consumer1 implements Runnable {
    private KafkaConsumer<String, String> consumer;

    private Consumer1(Properties props) {
        consumer = new KafkaConsumer<>(props);
    }

    private static Properties config() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "master:9092");
        properties.put("group.id", "Message");
        properties.put("key.deserializer",
                       "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer",
                       "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    public static void main(String[] args) throws Exception {
        /*Consumer1 consumer1 = new Consumer1(config());
        consumer1.run();*/
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        LocalTime start = LocalTime.now();
        list.stream().forEach(t -> {
            try {
                Thread.sleep(0L, 5);
            } catch (InterruptedException e) {

            }
        });
        LocalTime end = LocalTime.now();
        System.out.println("stream-foreach " +(end.getNano()-start.getNano()) );
        start = LocalTime.now();
        list.forEach(t -> {
            try {
                Thread.sleep(0L, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = LocalTime.now();
        System.out.println("foreach " + (end.getNano() - start.getNano()));


    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singleton("KAFKA_TEST"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(
                        Duration.ofSeconds(100L));
                for (ConsumerRecord<String, String> record : records) {
                    String format =
                            "topic =" + record.topic() + ",partition = " + record.partition() + ",offset = " + record.offset() + ",customer = " + record.key() + ",country = " + record.value();

                    System.out.println(format);
                }


            }
        } finally {
            consumer.close();
        }
    }
}
