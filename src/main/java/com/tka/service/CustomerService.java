package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.model.Customer;
import com.tka.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired private CustomerRepo customerDao;
    public void addCustomer(Customer customer) { customerDao.save(customer); }
    public Customer verifyLoginCred(String username, String password) {
        return customerDao.findByUsername(username).filter(c -> c.getPassword().equals(password)).orElse(null);
    }
    public Customer getCustomerById(int id) { return customerDao.findById(id).orElseThrow(() -> new RuntimeException("Customer not found: " + id)); }
}
