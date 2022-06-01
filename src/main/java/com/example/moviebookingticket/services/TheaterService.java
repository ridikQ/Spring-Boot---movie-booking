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

    public List<TheaterDto>getAllTheaters(){
        return theaterRepository.findAll().stream().map(theaterConverter::toDto).collect(Collectors.toList());
    }
    public void addTheater(TheaterDto theaterDto){
        TheaterEntity theaterEntity=theaterConverter.toEntity(theaterDto);
        theaterRepository.save(theaterEntity);
    }

    /*public List<TheaterEntity>getAllTheaters(){
        return theaterRepository.findAll();
    }
    public void addTheater(TheaterEntity theaterEntity){
        theaterRepository.save(theaterEntity);
    }*/
}
