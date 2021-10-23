package com.yash.mba.service;

import java.util.List;

import com.yash.mba.domain.Auditorium;

public interface AuditoriumService {
	   List<Auditorium> getAllAuditoriums();

	    Auditorium getAuditoriumById(Long auditorium_id);

	    Auditorium pushAuditorium(Auditorium newAuditorium);

	    Auditorium updateAuditorium(Auditorium updatedAuditorium, Long auditorium_id);

	    void deleteAuditoriumById(Long auditorium_id);
	}
