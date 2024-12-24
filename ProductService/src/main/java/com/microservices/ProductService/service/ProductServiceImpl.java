package com.microservices.ProductService.service;

import com.microservices.ProductService.entity.Product;
import com.microservices.ProductService.model.ProductRequest;
import com.microservices.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product..");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product added..");
        return product.getProductId();


    }
}
