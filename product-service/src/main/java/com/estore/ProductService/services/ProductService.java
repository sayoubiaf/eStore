package com.estore.ProductService.services;

import java.util.List;

import com.estore.ProductService.entities.Product;
import com.estore.ProductService.models.ProductDto;


public interface ProductService {
    Product create(ProductDto product);
    ProductDto getProductById(String id);
    List<Product> getAllProdut();
    String deleteProduct(String id);
    ProductDto updateProduct(ProductDto product, String id);
    void reduceQuantity(String id, long quantity);

}
