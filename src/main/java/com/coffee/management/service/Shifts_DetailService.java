package com.coffee.management.service;

import com.coffee.management.entity.Shifts_Detail;

import java.util.List;

public interface Shifts_DetailService {
    Shifts_Detail createNewShifts_Detail(Shifts_Detail shiftsDetail);
    List<Shifts_Detail> getAllShifts_Detail();

    Shifts_Detail getShifts_Detail(long id);

    void deleteShifts_Detail(long id);

    void updateShifts_Detail(Shifts_Detail newShifts_Detail, long id);
}
