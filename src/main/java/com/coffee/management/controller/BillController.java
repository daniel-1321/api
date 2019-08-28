package com.coffee.management.controller;

import com.coffee.management.entity.Bill;
import com.coffee.management.service.BillService;
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
 * Created on 20/08/2019.
 * Class: BillController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<Bill> createNewBill (@Valid @RequestBody Bill bill){
        Bill persistedBill = billService.createNewBill(bill);
        return new ResponseEntity<>(persistedBill, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getBill(){
        List<Bill> bills = billService.getAllBill();
        if (CollectionUtils.isEmpty(bills)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable long id){
        Bill bill = billService.getBill(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Bill> updateBill(@Valid @RequestBody Bill bill, @PathVariable long id){
        billService.updateBill(bill,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Bill> deleteAdmin(@PathVariable long id){
        billService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
