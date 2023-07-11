package com.moraes.strconsumer.listener;

import static com.moraes.strconsumer.custom.StrConsumerCustomListener.TOPIC_NAME;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.moraes.strconsumer.custom.StrConsumerCustomListener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

    private static final String GROUP_1 = "group 1";
    private static final String GROUP_2 = "group 2";

    // Can use this:
    // @KafkaListener(groupId = "group 1", topics = TOPIC_NAME,
    // containerFactory = "strContainerFactory")

    // Or this:
    // @KafkaListener(groupId = "group 1", topicPartitions = {@TopicPartition(
    // topic = TOPIC_NAME, partitions = { "0", "1" })

    @SneakyThrows
    @StrConsumerCustomListener(groupId = GROUP_1)
    public void listener0(String message) {
        log.info("Receive message listener0 {}", message);
        throw new IllegalAccessException("Exception ...");
    }

    @StrConsumerCustomListener(groupId = GROUP_1)
    public void listener1(String message) {
        log.info("Receive message listener1 {}", message);
    }

    @KafkaListener(groupId = GROUP_2, topics = TOPIC_NAME, containerFactory = "validMessageContainerFactory")
    public void listenerValid(String message) {
        log.info("Receive message listenerValid {}", message);
    }
}
