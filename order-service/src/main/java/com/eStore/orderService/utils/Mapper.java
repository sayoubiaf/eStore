package com.eStore.orderService.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.eStore.orderService.entities.Order;
import com.eStore.orderService.models.OrderDto;

@Component
public class Mapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public OrderDto ConvertOrderToDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public Order ConvertDtoToOrder(OrderDto orderDto){
        return modelMapper.map(orderDto, Order.class);
    }

}
