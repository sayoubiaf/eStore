package com.eStore.orderService.services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eStore.orderService.entities.Order;
import com.eStore.orderService.external.PaymentRequest;
import com.eStore.orderService.external.PaymentService;
import com.eStore.orderService.external.ProductService;
import com.eStore.orderService.models.OrderDto;
import com.eStore.orderService.repositories.OrderRepository;
import com.eStore.orderService.utils.Mapper;

import lombok.extern.log4j.Log4j2;

/**
 * OrderServiceImpl
 */
@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;
    
    @Autowired
    private Mapper mapper;


    // call product service
    @Autowired
    private ProductService productService;

    //used to call payment service
    
    @Autowired
    private PaymentService paymentService;
    
    @Override
    public String create(OrderDto orderDto) {
        log.info("Check products ...");

        productService.reduceQuantity(orderDto.getProductId(), orderDto.getQuantity());
        log.info("create order");
        Order order= mapper.ConvertDtoToOrder(orderDto);
            order.setId(UUID.randomUUID().toString());
            order.setDate(Instant.now());
       
            repository.save(order);
        log.info("Order created");

        //do payment
        
        paymentService.doPayment(PaymentRequest.builder()
                                .orderId(order.getId())
                                .amount(order.getTotalAmount())
                                .build());
        log.info("payment Completed");
         return order.getId();
    }

    @Override
    public OrderDto getOrder(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'getOrder'");
    }

    @Override
    public List<Order> getAllOrders() {
       
      return  repository.findAll();
    }

    
}