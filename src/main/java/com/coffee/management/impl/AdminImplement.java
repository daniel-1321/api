package com.coffee.management.impl;

import com.coffee.management.entity.Admin;
import com.coffee.management.repository.AdminRepository;
import com.coffee.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: AdminImplement.java
 */
@Service
@Transactional
public class AdminImplement implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin createNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(long id) {
        return adminRepository.getOne(id);
    }

    @Override
    public void deleteAdmin(long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void updateAdmin(Admin newAdmin, long id) {
        adminRepository.findById(id).map(admin ->{
            admin.setAdm_name(newAdmin.getAdm_name());
            admin.setAdm_password(newAdmin.getAdm_password());
            admin.setAdm_phone(newAdmin.getAdm_phone());
            admin.setAdm_address(newAdmin.getAdm_address());
            return adminRepository.save(admin);
        });
    }
}
