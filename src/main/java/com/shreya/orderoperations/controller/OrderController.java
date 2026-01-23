package com.shreya.orderoperations.controller;

import com.shreya.orderoperations.service.OrderService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);

    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

}
