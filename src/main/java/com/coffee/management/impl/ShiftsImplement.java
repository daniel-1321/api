package com.coffee.management.impl;

import com.coffee.management.entity.Shifts;
import com.coffee.management.repository.ShiftsRepository;
import com.coffee.management.service.ShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: ShiftsImplement.java
 */
@Service
@Transactional
public class ShiftsImplement implements ShiftsService {
    @Autowired
    ShiftsRepository shiftsRepository;
    @Override
    public Shifts createNewShifts(Shifts shifts) {
        return shiftsRepository.save(shifts);
    }

    @Override
    public List<Shifts> getAllShifts() {
        return shiftsRepository.findAll();
    }

    @Override
    public Shifts getShifts(long id) {
        return shiftsRepository.getOne(id);
    }

    @Override
    public void deleteShifts(long id) {
        shiftsRepository.deleteById(id);
    }

    @Override
    public void updateShifts(Shifts newShifts, long id) {
        shiftsRepository.findById(id).map(shifts -> {
            shifts.setShft_name(newShifts.getShft_name());
            shifts.setShft_start_time(newShifts.getShft_start_time());
            shifts.setShft_end_time(newShifts.getShft_end_time());
            shifts.setShft_description(newShifts.getShft_description());
            return shiftsRepository.save(newShifts);
        });
    }
}
