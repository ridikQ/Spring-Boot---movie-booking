package com.example.moviebookingticket.converters;

import com.example.moviebookingticket.dto.TimeTableDto;
import com.example.moviebookingticket.entity.TimeTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeTableConverter implements BidirectionalConverter<TimeTableDto, TimeTableEntity> {

    @Autowired
    private MovieConverter movieConverter;

    @Override
    public TimeTableDto toDto(TimeTableEntity timeTableEntity) {
        TimeTableDto timeTableDto = new TimeTableDto();
        timeTableDto.setId(timeTableEntity.getId());
        timeTableDto.setDate(timeTableEntity.getDate());
        timeTableDto.setStartTime(timeTableEntity.getStartTime());
        timeTableDto.setEndTime(timeTableEntity.getEndTime());
        timeTableDto.setMovieDto(movieConverter.toDto(timeTableEntity.getMovieEntity()));
        return timeTableDto;
    }

    @Override
    public TimeTableEntity toEntity(TimeTableDto timeTableDto) {
        TimeTableEntity timeTableEntity = new TimeTableEntity();
        timeTableEntity.setId(timeTableDto.getId());
        timeTableEntity.setDate(timeTableDto.getDate());
        timeTableEntity.setStartTime(timeTableDto.getStartTime());
        timeTableEntity.setEndTime(timeTableDto.getEndTime());
        timeTableEntity.setMovieEntity(movieConverter.getMovieId(timeTableDto.getMovieDto()));
        return timeTableEntity;
    }
}
