package com.homesphere.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    // 🔑 PUT YOUR KEYS HERE
    private static final String KEY = "rzp_test_SgAfPQSVmVK1OO";
    private static final String SECRET = "ymxkuhxcCIIGRW0yw3Xdg4jC";

    // ================= CREATE ORDER =================
    @PostMapping("/create-order")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> data) throws Exception {

        int amount = (int) data.get("amount");

        RazorpayClient client = new RazorpayClient(KEY, SECRET);

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // convert ₹ to paise
        options.put("currency", "INR");
        options.put("receipt", "txn_" + System.currentTimeMillis());

        Order order = client.orders.create(options);

        Map<String, Object> response = new HashMap<>();
        response.put("id", order.get("id"));
        response.put("amount", order.get("amount"));
        response.put("currency", order.get("currency"));

        return response;
    }

    // ================= PAYMENT SUCCESS (OPTIONAL SAVE) =================
    @PostMapping("/success")
    public String paymentSuccess(@RequestBody Map<String, Object> data) {

        // You can store payment details in DB here
        System.out.println("Payment Success: " + data);

        return "Payment stored successfully";
    }
}