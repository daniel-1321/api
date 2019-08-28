package com.coffee.management.service;

import com.coffee.management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createNewEmployee(Employee employee);
    List<Employee> getAllEmployee();

    Employee getEmployee(long id);

    void deleteEmployee(long id);

    void updateEmployee(Employee newEmployee, long id);
}
