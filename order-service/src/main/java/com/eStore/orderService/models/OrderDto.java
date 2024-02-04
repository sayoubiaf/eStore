package com.eStore.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String productId;
    private long quantity;
    private long totalAmount;
    
}
