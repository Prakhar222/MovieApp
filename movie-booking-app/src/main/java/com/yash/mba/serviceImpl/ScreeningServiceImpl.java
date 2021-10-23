package com.yash.mba.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.exception.ScreeningNotFoundException;
import com.yash.mba.domain.Screening;
import com.yash.mba.domain.Seat;
import com.yash.mba.repository.ScreeningRepository;
import com.yash.mba.service.ScreeningService;
@Service
@Primary
public class ScreeningServiceImpl implements ScreeningService {
	 private ScreeningRepository screeningRepository;

	    @Autowired
	    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
	        this.screeningRepository = screeningRepository;
	    }

	@Override
	public List<Screening> getAllScreenings() {
		// TODO Auto-generated method stub
        return screeningRepository.findAll();
	}

	@Override
	public Screening getScreeningById(Long screening_id) {
		// TODO Auto-generated method stub
        return screeningRepository.findById(screening_id).orElseThrow(ScreeningNotFoundException :: new);
	}

	@Override
	public Screening pushScreening(Screening newScreening) {
		// TODO Auto-generated method stub
		return screeningRepository.save(newScreening);
	}

	@Override
	public Screening updateScreening(Screening updatedScreening, Long screening_id) {
		// TODO Auto-generated method stub
		screeningRepository.findById(screening_id);
		updatedScreening.setId(screening_id);
		return screeningRepository.save(updatedScreening);
	}

//	@Override
//	public List<Seat> getSeatsByScreeningId(Long screening_id) {
//		// TODO Auto-generated method stub
//		Screening screening = getScreeningById(screening_id);
//        if (screening.getIsFull()) {
//            return new ArrayList<>();
//        }
//        return new ArrayList<>(screening.getAuditorium().getSeats());
//    }

	@Override
	public List<Screening> getAllScreenings(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
        return screeningRepository.findAll().stream().filter(screening -> screening.getDate().isAfter(startDate) && screening.getDate().isBefore(endDate)).collect(Collectors.toList());
	}

	@Override
	public List<Seat> getSeatsByScreeningId(Long screening_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
