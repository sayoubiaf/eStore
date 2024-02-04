package com.eStore.orderService.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eStore.orderService.entities.Order;
import com.eStore.orderService.models.OrderDto;
import com.eStore.orderService.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping()
    public ResponseEntity<String> add(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.create(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable String id){
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
}
