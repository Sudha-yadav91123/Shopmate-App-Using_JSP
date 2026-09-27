package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.model.Product;
import com.tka.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired private ProductRepo productRepo;
    @Autowired private CategoryService categoryService;

    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        for (Product product : products) {
            // Migrate legacy category text into the normalized Category table on first read.
            if (product.getCategory() == null && product.getLegacyCategory() != null && !product.getLegacyCategory().isBlank()) {
                product.setCategory(categoryService.getOrCreate(product.getLegacyCategory()));
                productRepo.save(product);
            }
            if (product.getImagepath() == null || product.getImagepath().isBlank()) {
                String pname = product.getPname();
                if (pname != null && !pname.isBlank()) product.setImagepath(pname.split(" ")[0].toLowerCase() + ".jpg");
            }
        }
        return products;
    }
    public Product getProductById(int id) { return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id)); }
}
