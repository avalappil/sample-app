package com.example.demo.service;

import com.example.demo.model.Order;

public interface OrderService {
    Order getOrder(String orderId);

    Order createOrder(Order order);
}
