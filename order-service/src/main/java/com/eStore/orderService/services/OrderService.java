package com.eStore.orderService.services;

import java.util.List;

import com.eStore.orderService.entities.Order;
import com.eStore.orderService.models.OrderDto;

public interface OrderService {
    String create(OrderDto orderDto);
    OrderDto getOrder(String id);
    List<Order> getAllOrders(); 
}
