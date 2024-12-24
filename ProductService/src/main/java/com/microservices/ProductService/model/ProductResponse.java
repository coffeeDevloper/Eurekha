package com.microservices.ProductService.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String productName;
    private long price;
    private long quantity;
    private long productId;
}
