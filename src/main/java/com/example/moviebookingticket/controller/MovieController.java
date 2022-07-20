package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.MovieDto;
import com.example.moviebookingticket.entity.MovieEntity;
import com.example.moviebookingticket.exception.IllegalStateException;
import com.example.moviebookingticket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity< List<MovieDto>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto)throws IllegalStateException{
        return ResponseEntity.ok(movieService.addMovie(movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity("Movie deleted",HttpStatus.NO_CONTENT);
    }
}
