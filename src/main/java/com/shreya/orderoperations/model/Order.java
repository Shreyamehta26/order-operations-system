package com.shreya.orderoperations.model;
import com.shreya.orderoperations.model.OrderStatus;


public class Order {
    private Long id;
    private String productName;
    private Double price;
    private OrderStatus status;

    public Order() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderStatus getStatus(){
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status=status;
    }
}
