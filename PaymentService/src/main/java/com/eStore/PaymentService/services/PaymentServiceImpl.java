package com.eStore.PaymentService.services;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eStore.PaymentService.entities.Payment;
import com.eStore.PaymentService.models.PaymentDto;
import com.eStore.PaymentService.repositories.PaymentRepository;
import com.eStore.PaymentService.utils.Mapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public long doPayment(PaymentDto paymentDto) {
        log.info("Adding Payment Details");

       Payment p= mapper.ConvertDtoToModel(paymentDto);

        p.setStatus("paid");
        p.setPaymentDate(Instant.now());
        // Payment p= Payment.builder()
        //                   .orderId(paymentDto.getOrderId())
        //                   .amount(paymentDto.getAmount())
        //                   .status("paid")
        //                   .paymentDate(Instant.now())
        //                   .build();

        paymentRepository.save(p);

        log.info("Payment Details succesuflly added");
        
        return p.getId();
    }

    @Override
    public long getPayment(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPayment'");
    }
    
}
