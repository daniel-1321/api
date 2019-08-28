package com.coffee.management.controller;

import com.coffee.management.entity.Customer;
import com.coffee.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: CustomerController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer (@Valid @RequestBody Customer customer){
        Customer persistedCustomer = customerService.createNewCustomer(customer);
        return new ResponseEntity<>(persistedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customer = customerService.getAllCustomer();
        if (CollectionUtils.isEmpty(customer)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable long id){
        customerService.updateCustomer(customer,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
