package com.coffee.management.impl;

import com.coffee.management.entity.Shifts_Detail;
import com.coffee.management.repository.Shifts_DetailRepository;
import com.coffee.management.service.Shifts_DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: Shifts_DetailImplement.java
 */
@Service
@Transactional
public class Shifts_DetailImplement implements Shifts_DetailService {
    @Autowired
    Shifts_DetailRepository shifts_detailRepository;
    @Override
    public Shifts_Detail createNewShifts_Detail(Shifts_Detail shiftsDetail) {
        return shifts_detailRepository.save(shiftsDetail);
    }

    @Override
    public List<Shifts_Detail> getAllShifts_Detail() {
        return shifts_detailRepository.findAll();
    }

    @Override
    public Shifts_Detail getShifts_Detail(long id) {
        return shifts_detailRepository.getOne(id);
    }

    @Override
    public void deleteShifts_Detail(long id) {
        shifts_detailRepository.deleteById(id);
    }

    @Override
    public void updateShifts_Detail(Shifts_Detail newShifts_Detail, long id) {
        shifts_detailRepository.findById(id).map(shifts_detail -> {
            shifts_detail.setShdt_note(newShifts_Detail.getShdt_note());
           return shifts_detailRepository.save(newShifts_Detail);
        });
    }
}
