package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.model.Cart;
import com.tka.model.CartItem;
import com.tka.model.Customer;
import com.tka.model.Product;
import com.tka.repository.CartItemRepo;
import com.tka.repository.CartRepo;
import com.tka.repository.CustomerRepo;
import com.tka.repository.ProductRepo;

@Service
public class CartService {
    @Autowired private CartRepo cartRepo;
    @Autowired private CartItemRepo cartItemRepo;
    @Autowired private CustomerRepo customerRepo;
    @Autowired private ProductRepo productRepo;

    private Cart getOrCreateCart(int customerId) {
        return cartRepo.findByCustomerCid(customerId).orElseGet(() -> {
            Customer customer = customerRepo.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
            Cart cart = new Cart(); cart.setCustomer(customer); return cartRepo.save(cart);
        });
    }

    @Transactional
    public void addToCart(int customerId, int productId) {
        Cart cart = getOrCreateCart(customerId);
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
        CartItem item = cartItemRepo.findByCartCartIdAndProductPid(cart.getCartId(), productId).orElse(null);
        if (item == null) { item = new CartItem(); item.setCart(cart); item.setProduct(product); item.setQuantity(0); }
        item.setQuantity(item.getQuantity() + 1);
        cartItemRepo.save(item);
    }

    public List<CartItem> getCartItems(int customerId) { return cartItemRepo.findByCartCustomerCid(customerId); }
    public int getCartCount(int customerId) { return getCartItems(customerId).stream().mapToInt(CartItem::getQuantity).sum(); }
    public double getTotalBill(int customerId) {
        return getCartItems(customerId).stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();
    }
    @Transactional
    public void removeFromCart(int customerId, int productId) {
        Cart cart = getOrCreateCart(customerId);
        cartItemRepo.findByCartCartIdAndProductPid(cart.getCartId(), productId).ifPresent(cartItemRepo::delete);
    }
    @Transactional
    public void clearCart(int customerId) {
        cartRepo.findByCustomerCid(customerId).ifPresent(cart -> cartItemRepo.deleteByCartCartId(cart.getCartId()));
    }
}
