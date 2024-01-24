package com.estore.ProductService.exception;

import lombok.Data;

/**
 * ProductCustomeExeption
 */
@Data
public class ProductCustomeExeption extends RuntimeException {

    private String errorCode;

    public ProductCustomeExeption(String message, String errorCode) {
        super(message);
        this.errorCode=errorCode;
    }
    
}