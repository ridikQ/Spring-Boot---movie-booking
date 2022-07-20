package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.MovieConverter;
import com.example.moviebookingticket.dto.MovieDto;
import com.example.moviebookingticket.entity.MovieEntity;
import com.example.moviebookingticket.entity.TheaterEntity;
import com.example.moviebookingticket.exception.IllegalStateException;
import com.example.moviebookingticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieConverter movieConverter;

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(movieConverter::toDto).collect(Collectors.toList());
    }

    public MovieDto addMovie(MovieDto movieDto) throws IllegalStateException{
        Optional<MovieEntity> movieByName=movieRepository.findMovieEntityByName(movieDto.getName());
        if (movieByName.isPresent()){
           throw new IllegalStateException("Movie Exist");
        }
        else {
            MovieEntity movieEntity=movieConverter.toEntity(movieDto);
            movieRepository.save(movieEntity);
            return movieDto;
        }

   }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
