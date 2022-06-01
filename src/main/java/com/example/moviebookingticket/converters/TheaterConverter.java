package com.example.moviebookingticket.converters;

import com.example.moviebookingticket.dto.TheaterDto;
import com.example.moviebookingticket.entity.TheaterEntity;

public class TheaterConverter implements BidirectionalConverter<TheaterDto, TheaterEntity>{
    @Override
    public TheaterDto toDto(TheaterEntity theaterEntity) {
        TheaterDto theaterDto=new TheaterDto();
        theaterDto.setId(theaterEntity.getId());
        theaterDto.setTheaterName(theaterEntity.getTheaterName());
        theaterDto.setSeatTotal(theaterEntity.getSeatTotal());
        return theaterDto;
    }

    @Override
    public TheaterEntity toEntity(TheaterDto theaterDto) {
        TheaterEntity theaterEntity=new TheaterEntity();
        theaterEntity.setId(theaterDto.getId());
        theaterEntity.setTheaterName(theaterDto.getTheaterName());
        theaterEntity.setSeatTotal(theaterDto.getSeatTotal());
        return theaterEntity;
    }
}
