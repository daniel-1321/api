package com.coffee.management.controller;

import com.coffee.management.entity.Shifts_Detail;
import com.coffee.management.service.Shifts_DetailService;
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
 * Class: Shifts_DetailController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/shifts_detail")
public class Shifts_DetailController {
    @Autowired
    Shifts_DetailService shifts_detailService;

    @PostMapping
    public ResponseEntity<Shifts_Detail> createNewShifts (@Valid @RequestBody Shifts_Detail shifts){
        Shifts_Detail persistedShifts = shifts_detailService.createNewShifts_Detail(shifts);
        return new ResponseEntity<>(persistedShifts, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shifts_Detail>> getShifts(){
        List<Shifts_Detail> shifts = shifts_detailService.getAllShifts_Detail();
        if (CollectionUtils.isEmpty(shifts)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(shifts,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Shifts_Detail> getShiftsById(@PathVariable long id){
        Shifts_Detail shifts = shifts_detailService.getShifts_Detail(id);
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Shifts_Detail> updateShifts(@Valid @RequestBody Shifts_Detail shifts, @PathVariable long id){
        shifts_detailService.updateShifts_Detail(shifts,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Shifts_Detail> deleteShifts(@PathVariable long id){
        shifts_detailService.deleteShifts_Detail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
