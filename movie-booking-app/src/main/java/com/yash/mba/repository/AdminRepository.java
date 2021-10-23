package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}