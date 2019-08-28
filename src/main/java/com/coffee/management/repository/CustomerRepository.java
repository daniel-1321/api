package com.coffee.management.repository;

import com.coffee.management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: CustomerRepository.java
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
