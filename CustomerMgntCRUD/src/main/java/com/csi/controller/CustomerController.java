package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Customer customer) {
        log.info("########TRYING TO SAVE DATA FOR CUSTOMER: " + customer.getCustName());
        customerServiceImpl.save(customer);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Customer> findById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<String> update(@PathVariable int custId, @RequestBody Customer customer) {

        log.info("########TRYING TO UPDATE DATA FOR CUSTOMER: " + customer.getCustName());
        customerServiceImpl.update(custId, customer);

        return ResponseEntity.ok("Data Updated Successfully");
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
