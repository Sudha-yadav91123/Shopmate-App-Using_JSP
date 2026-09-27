package com.tka.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCartCustomerCid(int customerId);
    Optional<CartItem> findByCartCartIdAndProductPid(int cartId, int productId);
    void deleteByCartCartId(int cartId);
}
