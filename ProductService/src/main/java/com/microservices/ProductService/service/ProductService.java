package com.microservices.ProductService.service;

import com.microservices.ProductService.model.ProductRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    long addProduct(ProductRequest productRequest);
}
