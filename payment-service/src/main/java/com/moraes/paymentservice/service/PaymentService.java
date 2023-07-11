package com.moraes.paymentservice.service;

import java.io.Serializable;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.moraes.paymentservice.model.Payment;
import com.moraes.paymentservice.util.ConstantsUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentService implements IPaymentService {

    private final KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @Override
    public void sendPayment(Payment payment) {
        log.info("GET Payment {}", payment);

        log.info("Send Payment {}", payment);
        jsonKafkaTemplate.send(ConstantsUtil.PAYMENT_TOPIC, payment);
    }
}
