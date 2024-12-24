package com.microservices.ordersService.service;

import com.microservices.ordersService.model.OrderRequest;


public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
