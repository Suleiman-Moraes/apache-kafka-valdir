package com.moraes.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moraes.paymentservice.model.Payment;

public interface IPaymentController {

    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
