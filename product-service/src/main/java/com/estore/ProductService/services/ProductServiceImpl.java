package com.estore.ProductService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.ProductService.entities.Product;
import com.estore.ProductService.exception.ProductCustomeExeption;
import com.estore.ProductService.models.ProductDto;
import com.estore.ProductService.repositories.ProductRepository;
import com.estore.ProductService.utils.Mapper;


import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public Product create(ProductDto productdto) {
       
       Product product= mapper.mapDtoToProduct(productdto);
        product.setId(UUID.randomUUID().toString());
       productRepo.save(product);
       log.info("Producted Created");
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
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public ProductDto updateProduct(ProductDto product, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void reduceQuantity(String id, long quantity) {
       Product product= productRepo.findById(id)
                                   .orElseThrow(()-> new ProductCustomeExeption(
                                    "Product with this Id not foud",
                                   "PRODUCT_NOT_FOUND"));
    if(product.getQuantity()<quantity){
        throw new ProductCustomeExeption("Producat does not have sufficient quantity",
         "INSUFFICIENT_QUATITY");
    }
    product.setQuantity(product.getQuantity()- quantity);

    productRepo.save(product);
    log.info("producted quantity reduced succesufuly");
        
    }
    
}
