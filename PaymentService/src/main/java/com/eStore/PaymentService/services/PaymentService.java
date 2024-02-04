package com.eStore.PaymentService.services;

import com.eStore.PaymentService.models.PaymentDto;

public interface PaymentService {
    long doPayment(PaymentDto paymentDto);
    long getPayment(long id);
}
