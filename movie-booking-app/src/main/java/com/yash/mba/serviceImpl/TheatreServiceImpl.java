package com.yash.mba.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.domain.Theatre;
import com.yash.mba.exception.MovieNotFoundException;
import com.yash.mba.repository.TheatreRepository;
import com.yash.mba.service.TheatreService;
@Service
@Primary
public class TheatreServiceImpl implements TheatreService {
	   private TheatreRepository theatreRepository;

	    public TheatreServiceImpl(TheatreRepository theatreRepository) {
	        this.theatreRepository = theatreRepository;
	    }

	@Override
	public List<Theatre> getAllTheatres() {
		// TODO Auto-generated method stub
		return theatreRepository.findAll();
	}

	@Override
	public Theatre getTheatreById(Long theatre_id) {
		// TODO Auto-generated method stub
		 return theatreRepository.findById(theatre_id).orElseThrow(() -> new MovieNotFoundException(theatre_id));
	}

	@Override
	public Theatre pushTheatre(Theatre newTheatre) {
		// TODO Auto-generated method stub
		return theatreRepository.save(newTheatre);
	}

	@Override
	public Theatre updateTheatre(Theatre updatedTheatre, Long theatre_id) {
		// TODO Auto-generated method stub
		theatreRepository.findById(theatre_id);
		updatedTheatre.setId(theatre_id);
		return theatreRepository.save(updatedTheatre);
	}

	@Override
	public void deleteTheatreById(Long theatre_id) {
		// TODO Auto-generated method stub
		 theatreRepository.deleteById(theatre_id);
	}

}
