package com.estore.ProductService.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estore.ProductService.entities.Product;
import com.estore.ProductService.models.ProductDto;
import com.estore.ProductService.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> add(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.create(productDto),HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProdut();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id){

        return  new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
}
