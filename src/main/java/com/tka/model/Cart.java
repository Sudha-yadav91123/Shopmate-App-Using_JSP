package com.tka.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @OneToOne @JoinColumn(name = "customer_id", unique = true, nullable = false) private Customer customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();
    public Cart() {}
    public int getCartId(){return cartId;} public void setCartId(int cartId){this.cartId=cartId;}
    public Customer getCustomer(){return customer;} public void setCustomer(Customer customer){this.customer=customer;}
    public List<CartItem> getItems(){return items;} public void setItems(List<CartItem> items){this.items=items;}
}
