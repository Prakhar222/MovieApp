package com.yash.mba.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Admin;
import com.yash.mba.domain.User;
import com.yash.mba.service.AdminService;
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmin();
    }
    @PostMapping("/check")
    public long checkAdminDetails(@RequestBody Admin admin) {



    List<Admin> admins=adminService.getAllAdmin();
    List<Admin> aEmail=admins.stream().filter(u -> u.getAdminEmail().matches(admin.getAdminEmail())).limit(1).toList();
    List<Admin> aPassword=admins.stream().filter(u -> u.getPassword().matches(admin.getPassword())).limit(1).toList();

    if (aEmail.size() >= 1 && aPassword.size() >=1) {
    Admin adminId=aPassword.get(0);
    return adminId.getId();
    }
    else
    return 0;
    }
}
