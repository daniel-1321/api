package com.coffee.management.service;

import com.coffee.management.entity.Customer;

import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: CustomerService.java
 */
public interface CustomerService {
    Customer createNewCustomer(Customer customer);
    List<Customer> getAllCustomer();

    Customer getCustomer(long id);

    void deleteCustomer(long id);

    void updateCustomer(Customer newCustomer, long id);
}
