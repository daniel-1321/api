package com.coffee.management.impl;

import com.coffee.management.entity.Customer;
import com.coffee.management.repository.CustomerRepository;
import com.coffee.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: CustomerImplement.java
 */
@Service
@Transactional
public class CustomerImplement implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer newCustomer, long id) {
        customerRepository.findById(id).map(customer -> {
            customer.setCus_name(newCustomer.getCus_name());
            customer.setCus_address(newCustomer.getCus_address());
            customer.setCus_dob(newCustomer.getCus_dob());
            customer.setCus_email(newCustomer.getCus_email());
            customer.setCus_gender(newCustomer.getCus_gender());
            customer.setCus_type(newCustomer.getCus_type());
            customer.setCus_password(newCustomer.getCus_password());
            customer.setCus_phone(newCustomer.getCus_phone());
            return customerRepository.save(newCustomer);
        });
    }
}
