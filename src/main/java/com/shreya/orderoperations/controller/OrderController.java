package com.shreya.orderoperations.controller;

import com.shreya.orderoperations.model.Order;
import com.shreya.orderoperations.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PutMapping("/{id}/cancel")
    public Order cancelOrder(@PathVariable Long id){
        return orderService.cancelOrder(id);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

}
