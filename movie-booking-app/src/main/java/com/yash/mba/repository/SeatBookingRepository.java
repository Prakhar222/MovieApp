package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.SeatBooking;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {
	
}
