package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.MovieDto;
import com.example.moviebookingticket.entity.MovieEntity;
import com.example.moviebookingticket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody MovieDto movieDto) {
        movieService.addMovie(movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
