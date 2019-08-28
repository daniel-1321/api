package com.coffee.management.service;

import com.coffee.management.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin createNewAdmin (Admin admin);
    List<Admin> getAllAdmin();

    Admin getAdmin(long id);

    void deleteAdmin(long id);

    void updateAdmin(Admin newAdmin, long id);
}
