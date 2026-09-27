package com.tka.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerCidOrderByOrderDateDesc(int customerId);
}
