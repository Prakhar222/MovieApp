package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

