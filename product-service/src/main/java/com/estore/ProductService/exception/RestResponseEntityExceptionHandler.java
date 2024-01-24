package com.estore.ProductService.exception;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.estore.ProductService.models.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ProductCustomeExeption.class)
    public ResponseEntity<ErrorResponse> handleResponseEntity(ProductCustomeExeption exeption){
        return new ResponseEntity<>(new ErrorResponse().builder()
                                                    .erorMessage(exeption.getMessage())
                                                    .errorCode(exeption.getErrorCode())
                                                    .build(),HttpStatus.NOT_FOUND );       
    }

}
