package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.model.Category;
import com.tka.repository.CategoryRepo;

@Service
public class CategoryService {
    @Autowired private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    public Category getOrCreate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category is required");
        }
        String clean = name.trim();
        return categoryRepo.findByNameIgnoreCase(clean).orElseGet(() -> {
            Category c = new Category();
            c.setName(clean);
            return categoryRepo.save(c);
        });
    }
}
