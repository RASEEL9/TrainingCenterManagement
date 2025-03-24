package com.example.controller;

import com.example.dto.PaymentDTO;
import com.example.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        logger.info("Fetching all payments");
        List<PaymentDTO> payments = paymentService.getAllPayments();
        logger.debug("Fetched {} payments", payments.size());
        return ResponseEntity.ok(payments);
    }

    //  Get Sorted Payments
    @GetMapping("/sorted")
    public ResponseEntity<List<PaymentDTO>> getAllPaymentsSorted(@RequestParam(defaultValue = "dateOfPayment") String sortBy) {
        logger.info("Fetching sorted payments by {}", sortBy);
        List<PaymentDTO> payments = paymentService.getAllPaymentsSorted(sortBy);
        logger.debug("Fetched {} sorted payments", payments.size());
        return ResponseEntity.ok(payments);
    }
}
