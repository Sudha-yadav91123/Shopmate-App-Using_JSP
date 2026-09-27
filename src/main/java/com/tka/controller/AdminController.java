package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.model.Category;
import com.tka.model.Product;
import com.tka.repository.CustomerRepo;
import com.tka.repository.ProductRepo;
import com.tka.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin")
    public String adminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLogin(
            String username,
            String password,
            HttpSession session,
            Model model) {

        if ("Admin".equals(username) && "Admin@123".equals(password)) {
            session.setAttribute("log", "admin");
            session.setAttribute("adminLoggedIn", true);
            return "redirect:/admin-dashboard";
        }

        model.addAttribute("msg", "Invalid Admin Credentials");
        return "admin-login";
    }

    @GetMapping("/admin-dashboard")
    public String adminDashboard(HttpSession session) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        return "admin-dashboard";
    }

    @GetMapping("/admin-logout")
    public String adminLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/manage-products")
    public String manageProducts(
            Model model,
            HttpSession session) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        model.addAttribute("products", productRepo.findAll());
        return "manage-products";
    }

    @GetMapping("/manage-customers")
    public String manageCustomers(
            Model model,
            HttpSession session) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        model.addAttribute("customers", customerRepo.findAll());
        return "manage-customers";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(
            @PathVariable int id,
            HttpSession session,
            RedirectAttributes ra) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        try {
            productRepo.deleteById(id);
            ra.addFlashAttribute("msg", "Product deleted successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute(
                    "msg",
                    "Product cannot be deleted because it is used in a cart or order.");
        }

        return "redirect:/manage-products";
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(
            @PathVariable int id,
            HttpSession session,
            RedirectAttributes ra) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        try {
            customerRepo.deleteById(id);
            ra.addFlashAttribute("msg", "Customer deleted successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("msg", "Customer could not be deleted.");
        }

        return "redirect:/manage-customers";
    }

    @GetMapping("/add-product")
    public String addProductPage(
            Model model,
            HttpSession session) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        model.addAttribute("categories", categoryService.getAllCategories());
        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(
            Product product,
            @RequestParam("categoryId") int categoryId,
            HttpSession session,
            RedirectAttributes ra) {

        if (!isAdminLoggedIn(session)) {
            return "redirect:/admin";
        }

        try {
            Category category = categoryService.getCategoryById(categoryId);
            product.setCategory(category);
            productRepo.save(product);

            ra.addFlashAttribute(
                    "msg",
                    product.getPname() + " added successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute(
                    "msg",
                    "Unable to save product: " + e.getMessage());
        }

        return "redirect:/manage-products";
    }

    private boolean isAdminLoggedIn(HttpSession session) {
        return Boolean.TRUE.equals(session.getAttribute("adminLoggedIn"))
                && "admin".equals(session.getAttribute("log"));
    }
}
