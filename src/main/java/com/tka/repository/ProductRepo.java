package com.tka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	// Ready-made CRUD methods from JpaRepository
}