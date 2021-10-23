package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
