package com.microservices.service.info.service;

import com.microservices.service.info.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();

    Optional<Movie> findById(int id);

    boolean create(Movie newMovie);

    boolean update(Movie movie, int id);

    int deleteById(int id);

    Optional<Movie> findByMovieId(String movieId);
}
