package com.csi.service;

import com.csi.dao.CustomerDao;
import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDaoImpl;


    @Override
    public void save(Customer customer) {
        customerDaoImpl.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDaoImpl.findAll();
    }

    @Override
    public Customer findById(int custId) {
        return customerDaoImpl.findById(custId);
    }

    @Override
    public void update(int custId, Customer customer) {
        customerDaoImpl.update(custId, customer);

    }

    @Override
    public void deleteById(int custId) {
        customerDaoImpl.deleteById(custId);
    }
}
