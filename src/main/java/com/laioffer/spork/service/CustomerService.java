package com.laioffer.spork.service;

import com.laioffer.spork.dao.CustomerDao;
import com.laioffer.spork.entity.Cart;
import com.laioffer.spork.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private CustomerDao customerDao;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(CustomerDao customerDao, PasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
