package com.microservices.ProductService.service;

import com.microservices.ProductService.entity.Product;
import com.microservices.ProductService.model.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    long addProduct(ProductRequest productRequest);

    Optional<Product> getProductById(long productId);
}
