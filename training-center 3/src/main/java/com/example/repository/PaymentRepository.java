package com.example.repository;

import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // ✅ Query method for filtering by payment state
    List<Payment> findByPaymentStateIgnoreCase(String status);
}
