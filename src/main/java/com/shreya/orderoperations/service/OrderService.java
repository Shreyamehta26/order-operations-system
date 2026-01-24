package com.shreya.orderoperations.service;

import com.shreya.orderoperations.model.Order;
import org.springframework.stereotype.Service;
import java.util.List;
import com.shreya.orderoperations.model.OrderStatus;
import com.shreya.orderoperations.exception.OrderNotFoundException;


import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private  long orderIdCounter=1L;

    public Order createOrder(Order order){
        order.setId(orderIdCounter);
        orderIdCounter++;

        order.setStatus(OrderStatus.CREATED);
        orders.add(order);
        return order;
    }

    public Order cancelOrder(Long orderId){
        for(Order order:orders){
            if(order.getId().equals(orderId)){
                if(order.getStatus().equals(OrderStatus.CANCELLED)){
                    throw new RuntimeException("Order cancelled");
                }
                order.setStatus(OrderStatus.CANCELLED);
                return order;
            }
        }
        throw new OrderNotFoundException("Order not found");
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
