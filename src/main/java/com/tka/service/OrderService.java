package com.tka.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.model.CartItem;
import com.tka.model.Customer;
import com.tka.model.OrderItem;
import com.tka.model.OrderStatus;
import com.tka.model.Orders;
import com.tka.repository.CustomerRepo;
import com.tka.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired private OrderRepo orderRepo;
    @Autowired private CustomerRepo customerRepo;
    @Autowired private CartService cartService;

    @Transactional
    public Orders createOrderFromCart(int customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
        List<CartItem> cartItems = cartService.getCartItems(customerId);
        if (cartItems.isEmpty()) throw new IllegalStateException("Cart is empty");
        Orders order = new Orders();
        order.setCustomer(customer); order.setStatus(OrderStatus.PENDING_PAYMENT); order.setOrderDate(LocalDateTime.now());
        List<OrderItem> items = new ArrayList<>(); double total = 0;
        for (CartItem cartItem : cartItems) {
            double price = cartItem.getProduct().getPrice();
            double subtotal = price * cartItem.getQuantity();
            OrderItem item = new OrderItem();
            item.setOrder(order); item.setProduct(cartItem.getProduct()); item.setQuantity(cartItem.getQuantity());
            item.setPrice(price); item.setSubtotal(subtotal); items.add(item); total += subtotal;
        }
        order.setItems(items); order.setTotalAmount(total);
        return orderRepo.save(order);
    }
    public Orders save(Orders order) { return orderRepo.save(order); }
    public List<Orders> getCustomerOrders(int customerId) { return orderRepo.findByCustomerCidOrderByOrderDateDesc(customerId); }
}
