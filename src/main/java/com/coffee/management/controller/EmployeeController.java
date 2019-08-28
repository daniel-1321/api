package com.coffee.management.controller;

import com.coffee.management.entity.Employee;
import com.coffee.management.service.EmployeeService;
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
 * Created on 19/08/2019.
 * Class: EmployeeCustomer.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createNewEmployee (@Valid @RequestBody Employee employee){
        Employee persistedEmployee = employeeService.createNewEmployee(employee);
        return new ResponseEntity<>(persistedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> employee = employeeService.getAllEmployee();
        if (CollectionUtils.isEmpty(employee)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable long id){
        employeeService.updateEmployee(employee,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
