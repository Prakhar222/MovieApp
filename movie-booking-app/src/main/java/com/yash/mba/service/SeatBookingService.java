package com.yash.mba.service;
import java.util.List;

import com.yash.mba.domain.SeatBooking;


public interface SeatBookingService {

	List<SeatBooking> getAllSeatBooking();

	SeatBooking getSeatBookingById(Long seat_booking_id);

	SeatBooking pushSeatBooking(SeatBooking newSeatBooking);

	void deleteSeatBookingById(Long seat_booking_id);
}
