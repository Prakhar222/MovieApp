package com.yash.mba.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.domain.Admin;
import com.yash.mba.repository.AdminRepository;
import com.yash.mba.service.AdminService;
@Service
@Primary
public class AdminServiceImpl implements AdminService{
	 private AdminRepository adminRepository;

	    public AdminServiceImpl(AdminRepository adminRepository) {
	        this.adminRepository = adminRepository;
	    }

		@Override
		public List<Admin> getAllAdmin() {
			// TODO Auto-generated method stub
			return adminRepository.findAll();
		}

		@Override
		public Admin getAdminById(Long admin_id) {
			// TODO Auto-generated method stub
			return adminRepository.getById(admin_id);
		}


}
