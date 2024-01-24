package com.estore.ProductService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estore.ProductService.entities.Product;


public interface ProductRepository extends JpaRepository<Product,String> {
    
}
