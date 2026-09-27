package com.tka.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
    public Category() {}
    public int getCategoryId(){return categoryId;} public void setCategoryId(int categoryId){this.categoryId=categoryId;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public List<Product> getProducts(){return products;} public void setProducts(List<Product> products){this.products=products;}
}
