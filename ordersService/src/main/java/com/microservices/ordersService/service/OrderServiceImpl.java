package com.microservices.ordersService.service;

import com.microservices.ordersService.entity.Order;
import com.microservices.ordersService.model.OrderRequest;
import com.microservices.ordersService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        //Order Entity -> Save the data with Status Order Created
        //Product Service -> Block Products (Reduce Quantity)
        //Payment Service -> Payments -> Success -> COMPLETED, Else CANCELLED

        log.info("Placing Order Request : {}" , orderRequest);
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        order = orderRepository.save(order);
        log.info("Order Placed Successfully with Order Id: {}", order.getOrderId());
        return order.getOrderId();
    }
}
