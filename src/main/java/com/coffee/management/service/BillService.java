package com.coffee.management.service;

import com.coffee.management.entity.Bill;

import java.util.List;

public interface BillService {
    Bill createNewBill (Bill bill);
    List<Bill> getAllBill();

    Bill getBill(long id);

    void deleteBill(long id);

    void updateBill(Bill newBill, long id);
}
