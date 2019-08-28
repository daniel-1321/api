package com.coffee.management.controller;

import com.coffee.management.entity.Shifts;
import com.coffee.management.service.ShiftsService;
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
 * Class: ShiftsController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/shifts")
public class ShiftsController {
    @Autowired
    private ShiftsService shiftsService;

    @PostMapping
    public ResponseEntity<Shifts> createNewShifts (@Valid @RequestBody Shifts shifts){
        Shifts persistedShifts = shiftsService.createNewShifts(shifts);
        return new ResponseEntity<>(persistedShifts, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shifts>> getShifts(){
        List<Shifts> shifts = shiftsService.getAllShifts();
        if (CollectionUtils.isEmpty(shifts)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(shifts,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Shifts> getShiftsById(@PathVariable long id){
        Shifts shifts = shiftsService.getShifts(id);
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Shifts> updateShifts(@Valid @RequestBody Shifts shifts, @PathVariable long id){
        shiftsService.updateShifts(shifts,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Shifts> deleteShifts(@PathVariable long id){
        shiftsService.deleteShifts(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
