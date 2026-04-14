package com.homesphere.service;

import com.homesphere.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment makePayment(Payment payment);

    List<Payment> getPaymentsByUser(Long userId);
}