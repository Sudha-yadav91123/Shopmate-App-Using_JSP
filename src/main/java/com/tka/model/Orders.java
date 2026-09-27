package com.tka.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalAmount;
    @Enumerated(EnumType.STRING) private OrderStatus status;
    private LocalDateTime orderDate;
    @ManyToOne @JoinColumn(name = "customer_id", nullable = false) private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Orders() {}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double totalAmount){this.totalAmount=totalAmount;}
    public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus status){this.status=status;}
    public LocalDateTime getOrderDate(){return orderDate;} public void setOrderDate(LocalDateTime orderDate){this.orderDate=orderDate;}
    public Customer getCustomer(){return customer;} public void setCustomer(Customer customer){this.customer=customer;}
    public List<OrderItem> getItems(){return items;} public void setItems(List<OrderItem> items){this.items=items;}
}
