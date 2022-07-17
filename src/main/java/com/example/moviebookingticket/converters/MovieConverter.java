package com.example.moviebookingticket.converters;

import com.example.moviebookingticket.dto.MovieDto;
import com.example.moviebookingticket.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter implements BidirectionalConverter<MovieDto, MovieEntity> {

    @Autowired
    private TheaterConverter theaterConverter;

    @Override
    public MovieDto toDto(MovieEntity movieEntity) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movieEntity.getId());
        movieDto.setName(movieEntity.getName());
        movieDto.setType(movieEntity.getType());
        movieDto.setTechnology(movieEntity.getTechnology());
        movieDto.setRating(movieEntity.getRating());
        movieDto.setTheater(theaterConverter.toDto(movieEntity.getTheater()));
        return movieDto;
    }

    @Override
    public MovieEntity toEntity(MovieDto movieDto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(movieDto.getId());
        movieEntity.setName(movieDto.getName());
        movieEntity.setType(movieDto.getType());
        movieEntity.setTechnology(movieDto.getTechnology());
        movieEntity.setRating(movieDto.getRating());
        movieEntity.setTheater(theaterConverter.toEntity(movieDto.getTheater()));
        return movieEntity;
    }
}
