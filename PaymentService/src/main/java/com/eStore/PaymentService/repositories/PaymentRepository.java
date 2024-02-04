package com.eStore.PaymentService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eStore.PaymentService.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    
}
