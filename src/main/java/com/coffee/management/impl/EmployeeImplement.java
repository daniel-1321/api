package com.coffee.management.impl;

import com.coffee.management.entity.Employee;
import com.coffee.management.repository.EmployeeRepository;
import com.coffee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: EmployeeImplement.java
 */
@Service
@Transactional
public class EmployeeImplement implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee newEmployee, long id) {
        employeeRepository.findById(id).map(employee -> {
            employee.setEmp_name(newEmployee.getEmp_name());
            employee.setEmp_address(newEmployee.getEmp_address());
            employee.setEmp_dob(newEmployee.getEmp_dob());
            employee.setEmp_email(newEmployee.getEmp_email());
            employee.setEmp_gender(newEmployee.getEmp_gender());
            employee.setEmp_ismanager(newEmployee.getEmp_ismanager());
            employee.setEmp_password(newEmployee.getEmp_password());
            employee.setEmp_phone(newEmployee.getEmp_phone());
            return employeeRepository.save(newEmployee);
        });
    }
}
