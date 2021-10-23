package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}