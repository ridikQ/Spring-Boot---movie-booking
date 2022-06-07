package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.MovieConverter;
import com.example.moviebookingticket.converters.TimeTableConverter;
import com.example.moviebookingticket.dto.TimeTableDto;
import com.example.moviebookingticket.entity.TimeTableEntity;
import com.example.moviebookingticket.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableService {
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private TimeTableConverter timeTableConverter;

    public void addTimeTable(TimeTableDto timeTableDto) {
        TimeTableEntity timeTableEntity = timeTableConverter.toEntity(timeTableDto);
        timeTableRepository.save(timeTableEntity);
    }
}

