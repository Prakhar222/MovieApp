package com.yash.mba.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.exception.MovieNotFoundException;
import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Screening;
import com.yash.mba.repository.MovieRepository;
import com.yash.mba.service.MovieService;
import java.util.stream.Collectors;

@Service
@Primary
public class MovieServiceImpl implements MovieService{
	  private MovieRepository movieRepository;

	    @Autowired
	    public MovieServiceImpl(MovieRepository movieRepository) {
	        this.movieRepository = movieRepository;
	    }
	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Long movie_id) {
		// TODO Auto-generated method stub
        return movieRepository.findById(movie_id).orElseThrow(() -> new MovieNotFoundException(movie_id));
	}

	@Override
	public Movie saveMovie(Movie newMovie) {
		// TODO Auto-generated method stub
		return movieRepository.save(newMovie);
	}

	@Override
	public Movie updateMovie(Movie updatedMovie, Long movie_id) {
		// TODO Auto-generated method stub
		movieRepository.findById(movie_id);
		updatedMovie.setId(movie_id);
		return movieRepository.save(updatedMovie);
	}

	@Override
	public void deleteMovie(Long movie_id) {
		// TODO Auto-generated method stub
		 movieRepository.deleteById(movie_id);
		
	}
	@Override
	public List<Screening> getAllScreeningByMovieId(Long movie_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Screening> getAllScreeningByMovieIdAndDate(Long movie_id, LocalDate localDate) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Screening> getAllScreeningByMovieId(Long movie_id) {
//		  Movie movie = getMovieById(movie_id);
//	        return new ArrayList<>(movie.getScreenings());
//	}
//
//	@Override
//	public List<Screening> getAllScreeningByMovieIdAndDate(Long movie_id, LocalDate localDate) {
//		// TODO Auto-generated method stub
//        Movie movie = getMovieById(movie_id);
//        return movie.getScreenings().stream().filter(screening -> screening.getDate().equals(localDate)).collect(Collectors.toList());
//
//	}

}
