package com.example.moviebookingticket.converters;

import com.example.moviebookingticket.dto.TheaterDto;
import com.example.moviebookingticket.entity.TheaterEntity;
import org.springframework.stereotype.Component;

@Component
public class TheaterConverter implements BidirectionalConverter<TheaterDto, TheaterEntity> {
    @Override
    public TheaterDto toDto(TheaterEntity theaterEntity) {
        TheaterDto theaterDto = new TheaterDto();
        theaterDto.setId(theaterEntity.getId());
        theaterDto.setTheaterName(theaterEntity.getTheaterName());
        theaterDto.setSeatAvailable(theaterEntity.getSeatAvailable());
        return theaterDto;
    }

    @Override
    public TheaterEntity toEntity(TheaterDto theaterDto) {
        TheaterEntity theaterEntity = new TheaterEntity();
        theaterEntity.setId(theaterDto.getId());
        theaterEntity.setTheaterName(theaterDto.getTheaterName());
        theaterEntity.setSeatAvailable(theaterDto.getSeatAvailable());
        return theaterEntity;
    }
}
