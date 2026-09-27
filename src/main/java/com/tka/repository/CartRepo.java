package com.tka.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByCustomerCid(int customerId);
}
