package com.eStore.orderService.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order {
    
    @Id
    private String id;
    private String productId;
    private long quantity;
    private long totalAmount;
    private Instant date;
}
