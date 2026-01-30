package com.shreya.orderoperations.service;

import com.shreya.orderoperations.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

import com.shreya.orderoperations.model.OrderStatus;
import com.shreya.orderoperations.exception.OrderNotFoundException;

import java.util.ArrayList;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private long orderIdCounter = 1L;

    public Order createOrder(Order order) {
        order.setId(orderIdCounter);                    //CREATES ORDER
        orderIdCounter++;

        order.setStatus(OrderStatus.CREATED);
        orders.add(order);
        return order;
    }


    public Order cancelOrder(Long orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {                            //CANCEL ORDER
                if (order.getStatus() == (OrderStatus.CANCELLED)) {
                    throw new RuntimeException("Order cancelled");
                }


                order.setStatus(OrderStatus.CANCELLED);
                return order;
            }
        }
        throw new OrderNotFoundException("Order not found");
    }


        public Order getOrderById (Long orderId){
            for (Order order : orders) {
                if (order.getId().equals(orderId)) {
                    return order;

                }
            }


            throw new OrderNotFoundException("Order not found");
        }

        public List<Order> getAllOrders () {
            return orders;
        }
    }




