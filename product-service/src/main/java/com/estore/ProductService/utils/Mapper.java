package com.estore.ProductService.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.estore.ProductService.entities.Product;
import com.estore.ProductService.models.ProductDto;

@Component
public class Mapper {
     private static final ModelMapper modelMapper = new ModelMapper();

     public ProductDto mapProductToDto(Product product){
        return modelMapper.map(product, ProductDto.class);
     }

     public Product mapDtoToProduct(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
     }
}
