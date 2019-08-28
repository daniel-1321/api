package com.coffee.management.impl;

import com.coffee.management.entity.Bill;
import com.coffee.management.repository.BillRepository;
import com.coffee.management.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 20/08/2019.
 * Class: BillImplement.java
 */
@Service
@Transactional
public class BillImplement implements BillService {
    @Autowired
    BillRepository billRepository;
    @Override
    public Bill createNewBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBill(long id) {
        return billRepository.getOne(id);
    }

    @Override
    public void deleteBill(long id) {
        billRepository.deleteById(id);
    }

    @Override
    public void updateBill(Bill newBill, long id) {
        billRepository.findById(id).map(bill -> {
            bill.setBll_type(newBill.getBll_type());
            bill.setBll_payment(newBill.getBll_payment());
            bill.setBll_total(newBill.getBll_total());
            bill.setBll_note((newBill.getBll_note()));
            return billRepository.save(newBill);
        });
    }
}
