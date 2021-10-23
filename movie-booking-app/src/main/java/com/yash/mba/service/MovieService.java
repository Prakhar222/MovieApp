package com.yash.mba.service;

import java.time.LocalDate;
import java.util.List;

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Screening;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long movie_id);

    Movie saveMovie(Movie newMovie);

    Movie updateMovie(Movie updatedMovie, Long movie_id);

    void deleteMovie(Long movie_id);

    List<Screening> getAllScreeningByMovieId(Long movie_id);

    List<Screening> getAllScreeningByMovieIdAndDate(Long movie_id, LocalDate localDate);
}