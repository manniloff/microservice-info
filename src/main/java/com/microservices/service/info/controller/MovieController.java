package com.microservices.service.info.controller;

import com.microservices.service.info.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieController {

    @GetMapping(value = {"/{id}"}, produces = "application/json")
    Movie getMovieInfo(@PathVariable String id){
        return new Movie(id,"Test");
    }
}
