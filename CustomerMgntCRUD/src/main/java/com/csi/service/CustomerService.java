package com.csi.service;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerService {
    public void save(Customer customer);

    public List<Customer> findAll();

    public Customer findById(int custId);

    public void update(int custId,Customer customer);

    public void deleteById(int custId);
}
