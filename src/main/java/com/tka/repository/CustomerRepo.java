package com.tka.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUsername(String username);
    Optional<Customer> findByEmail(String email);
}
