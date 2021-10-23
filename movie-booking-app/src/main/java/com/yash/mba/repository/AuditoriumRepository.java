package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
