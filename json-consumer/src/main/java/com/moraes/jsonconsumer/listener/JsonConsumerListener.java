package com.moraes.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.moraes.jsonconsumer.model.Payment;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonConsumerListener {

    @KafkaListener(groupId = "group 1", topics = "payment-topic", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Verify");
        log.info("Ok {}", payment);
    }
}
