package com.tka.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pname;
    private String imagepath;
    private double price;
    // Legacy read-only column keeps existing category text available during migration.
    @Column(name = "category", insertable = false, updatable = false)
    private String legacyCategory;
    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product") private List<OrderItem> orderItems = new ArrayList<>();
    @OneToMany(mappedBy = "product") private List<CartItem> cartItems = new ArrayList<>();

    public Product() {}
    public int getPid(){return pid;} public void setPid(int pid){this.pid=pid;}
    public String getPname(){return pname;} public void setPname(String pname){this.pname=pname;}
    public String getImagepath(){return imagepath;} public void setImagepath(String imagepath){this.imagepath=imagepath;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
    public String getLegacyCategory(){return legacyCategory;} public void setLegacyCategory(String legacyCategory){this.legacyCategory=legacyCategory;}
    public Category getCategory(){return category;} public void setCategory(Category category){this.category=category;}
    public List<OrderItem> getOrderItems(){return orderItems;} public void setOrderItems(List<OrderItem> orderItems){this.orderItems=orderItems;}
    public List<CartItem> getCartItems(){return cartItems;} public void setCartItems(List<CartItem> cartItems){this.cartItems=cartItems;}
}
