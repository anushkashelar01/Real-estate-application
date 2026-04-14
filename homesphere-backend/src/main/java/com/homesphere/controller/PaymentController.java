package com.homesphere.controller;

import com.homesphere.model.Payment;
import com.homesphere.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }

    @GetMapping("/{userId}")
    public List<Payment> getPayments(@PathVariable Long userId) {
        return paymentService.getPaymentsByUser(userId);
    }
}