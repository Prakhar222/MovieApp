package com.yash.mba.service;

import java.util.List;

import com.yash.mba.domain.Admin;

public interface AdminService {
	
    List<Admin> getAllAdmin();

    Admin getAdminById(Long admin_id);

  
}

