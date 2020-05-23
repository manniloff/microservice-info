package com.microservices.service.info.controller;

import com.microservices.service.info.model.Movie;
import com.microservices.service.info.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class MovieController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;

    @GetMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping(value = {"/movie/{movieId}"}, produces = "application/json")
    ResponseEntity<?> findByMovieId(@PathVariable String movieId) {
        return ResponseEntity.ok(movieService.findByMovieId(movieId));
    }

    @PostMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> create(@RequestBody Movie newMovie) {
        return ResponseEntity.ok(movieService.create(newMovie));
    }

    @PutMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> update(@RequestBody Movie newMovie, @PathVariable int id) {
        return ResponseEntity.ok(movieService.update(newMovie, id));
    }

    @DeleteMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.deleteById(id));
    }
}
