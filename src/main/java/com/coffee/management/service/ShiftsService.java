package com.coffee.management.service;

import com.coffee.management.entity.Shifts;

import java.util.List;

public interface ShiftsService {
    Shifts createNewShifts(Shifts shifts);
    List<Shifts> getAllShifts();

    Shifts getShifts(long id);

    void deleteShifts(long id);

    void updateShifts(Shifts newShifts, long id);
}
