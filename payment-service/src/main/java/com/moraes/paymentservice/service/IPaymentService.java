package com.moraes.paymentservice.service;

import com.moraes.paymentservice.model.Payment;

public interface IPaymentService {

    void sendPayment(Payment payment);
}
