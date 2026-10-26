package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrder(String orderId) {
        return new Order(orderId, "CUSTOMER-100", "COMPLETED");
    }

    @Override
    public Order createOrder(Order order) {
        return new Order(order.orderId(), order.customerId(), "CREATED");
    }
}
