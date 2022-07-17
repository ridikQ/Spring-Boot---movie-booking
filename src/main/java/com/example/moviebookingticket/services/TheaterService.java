package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.TheaterConverter;
import com.example.moviebookingticket.dto.TheaterDto;
import com.example.moviebookingticket.entity.TheaterEntity;
import com.example.moviebookingticket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterConverter theaterConverter;

    public List<TheaterDto> getAllTheaters() {
        return theaterRepository.findAll().stream().map(theaterConverter::toDto).collect(Collectors.toList());
    }

    public TheaterDto addTheater(TheaterDto theaterDto) {
        TheaterEntity theaterEntity = theaterConverter.toEntity(theaterDto);
        theaterRepository.save(theaterEntity);
        return theaterDto;
    }


}
