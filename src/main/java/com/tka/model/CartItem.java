package com.tka.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cart_id", "product_id"}))
public class CartItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
    @ManyToOne @JoinColumn(name = "cart_id", nullable = false) private Cart cart;
    @ManyToOne @JoinColumn(name = "product_id", nullable = false) private Product product;
    private int quantity;
    public CartItem() {}
    public int getCartItemId(){return cartItemId;} public void setCartItemId(int cartItemId){this.cartItemId=cartItemId;}
    public Cart getCart(){return cart;} public void setCart(Cart cart){this.cart=cart;}
    public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
}
