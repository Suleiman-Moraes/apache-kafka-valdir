package com.moraes.strproducer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.moraes.strproducer.util.ConstantsUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(ConstantsUtil.STR_TOPIC, message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Error sending message: {}", ex.getMessage());
                return;
            }
            log.info("Message sent successfully: {}", result.getProducerRecord().value());
            log.info(
                    "Partition {}, Offset {}",
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset());
        });
    }
}
