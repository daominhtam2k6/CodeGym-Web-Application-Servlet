package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

/**
 * Dinh nghia cac thao tac quan ly Customer.
 */
public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}