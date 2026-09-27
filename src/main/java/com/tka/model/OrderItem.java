package com.tka.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @ManyToOne @JoinColumn(name = "order_id", nullable = false) private Orders order;
    @ManyToOne @JoinColumn(name = "product_id", nullable = false) private Product product;
    private int quantity;
    private double price;
    private double subtotal;

    public OrderItem() {}
    public int getOrderItemId(){return orderItemId;} public void setOrderItemId(int orderItemId){this.orderItemId=orderItemId;}
    public Orders getOrder(){return order;} public void setOrder(Orders order){this.order=order;}
    public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
    public double getSubtotal(){return subtotal;} public void setSubtotal(double subtotal){this.subtotal=subtotal;}
}
