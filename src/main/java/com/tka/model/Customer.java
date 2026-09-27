package com.tka.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String fullname;
    @Column(unique = true, nullable = false) private String email;
    private long mobile;
    private String address;
    @Column(unique = true, nullable = false) private String username;
    private String password;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    public Customer() {}
    public int getCid(){return cid;} public void setCid(int cid){this.cid=cid;}
    public String getFullname(){return fullname;} public void setFullname(String fullname){this.fullname=fullname;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public long getMobile(){return mobile;} public void setMobile(long mobile){this.mobile=mobile;}
    public String getAddress(){return address;} public void setAddress(String address){this.address=address;}
    public String getUsername(){return username;} public void setUsername(String username){this.username=username;}
    public String getPassword(){return password;} public void setPassword(String password){this.password=password;}
    public Cart getCart(){return cart;} public void setCart(Cart cart){this.cart=cart;}
    public List<Orders> getOrders(){return orders;} public void setOrders(List<Orders> orders){this.orders=orders;}
    @Override public String toString(){return "Customer [cid="+cid+", fullname="+fullname+", username="+username+"]";}
}
