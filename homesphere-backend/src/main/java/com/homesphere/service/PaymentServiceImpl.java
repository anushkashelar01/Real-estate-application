package com.homesphere.service;

import com.homesphere.model.Payment;
import com.homesphere.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 💳 MAKE PAYMENT
    @Override
    public Payment makePayment(Payment payment) {

        payment.setTimestamp(LocalDateTime.now());

        // 🔥 Dummy logic (always success)
        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);
    }

    // 📄 GET USER PAYMENTS
    @Override
    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }
}