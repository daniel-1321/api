package com.coffee.management.controller;


import com.coffee.management.entity.Admin;
import com.coffee.management.service.AdminService;
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
 * Class: AdminController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createNewAdmin (@Valid @RequestBody Admin admin){
        Admin persistedAdmin = adminService.createNewAdmin(admin);
        return new ResponseEntity<>(persistedAdmin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAdmin(){
        List<Admin> admin = adminService.getAllAdmin();
        if (CollectionUtils.isEmpty(admin)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(admin,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable long id){
        Admin admin = adminService.getAdmin(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin, @PathVariable long id){
        adminService.updateAdmin(admin,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
