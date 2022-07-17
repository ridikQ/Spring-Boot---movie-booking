package com.example.moviebookingticket.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter

public class TimeTableDto {

    private Long id;

    private Date date;

    private  Time startTime;

    private Time endTime;

    private MovieDto movieDto;
}
