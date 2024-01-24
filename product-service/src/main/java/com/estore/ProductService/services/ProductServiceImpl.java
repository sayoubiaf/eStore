package com.estore.ProductService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.ProductService.cofig.Mapper;
import com.estore.ProductService.entities.Product;
import com.estore.ProductService.exception.ProductCustomeExeption;
import com.estore.ProductService.models.ProductDto;
import com.estore.ProductService.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public Product create(ProductDto productdto) {
       Product product= mapper.mapDtoToProduct(productdto);
        product.setId(UUID.randomUUID().toString());

    //    Product p= Product.builder()
    //                     .id(UUID.randomUUID().toString())
    //                     .name(productdto.getName())
    //                     .price(productdto.getPrice())
    //                     .quantity(productdto.getQuantity())
    //                     .build();
       productRepo.save(product);
       return product;
    }

    @Override
    public ProductDto getProductById(String id) {
     Product product= productRepo.findById(id).orElseThrow(()->new ProductCustomeExeption("Product not found","PRODUCT_NOT_FOUND"));

     return mapper.mapProductToDto(product);
    }

    @Override
    public List<Product> getAllProdut() {
        return productRepo.findAll();
    }

    @Override
    public String deleteProduct(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public ProductDto updateProduct(ProductDto product, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }
    
}
