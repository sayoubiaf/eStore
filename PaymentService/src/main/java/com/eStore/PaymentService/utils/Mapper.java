package com.eStore.PaymentService.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.eStore.PaymentService.entities.Payment;
import com.eStore.PaymentService.models.PaymentDto;

@Component
public class Mapper {

    private static  ModelMapper modelMapper = new ModelMapper();
    public Mapper() {
        super();
        modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public PaymentDto ConvertModelToDto(Payment payment){
        return modelMapper.map(payment, PaymentDto.class);
    }

    public Payment ConvertDtoToModel(PaymentDto paymentDto) {
        return modelMapper.map(paymentDto, Payment.class);
    }

   

}
