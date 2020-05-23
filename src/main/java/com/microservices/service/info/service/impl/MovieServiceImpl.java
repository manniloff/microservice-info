package com.microservices.service.info.service.impl;

import com.microservices.service.info.model.Movie;
import com.microservices.service.info.repository.MovieRepository;
import com.microservices.service.info.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public boolean create(Movie newMovie) {
        try {
            movieRepository.save(newMovie);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Movie movie, int id) {
        try {
            Movie updated = new Movie();
            movieRepository.findById(id)
                    .ifPresent(m -> {
                        updated.setId(m.getId());
                        updated.setMovieId(movie.getMovieId());
                        updated.setName(movie.getName());
                    });
            movieRepository.save(updated);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public int deleteById(int id) {
        movieRepository.findById(id).ifPresent(r ->
                movieRepository.deleteById(r.getId())
        );
        return id;
    }

    @Override
    public Optional<Movie> findByMovieId(String movieId) {
        return movieRepository.findByMovieId(movieId);
    }
}
