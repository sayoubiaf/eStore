package com.eStore.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eStore.orderService.entities.Order;

public interface OrderRepository extends JpaRepository<Order,String> {
    
}
