package com.tka.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tka.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Optional<Category> findByNameIgnoreCase(String name);
}
