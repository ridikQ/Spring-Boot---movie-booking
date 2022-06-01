package com.example.moviebookingticket.dto;

import com.example.moviebookingticket.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class BookingDto {

    private Long id;

    private Integer seatAmount;

    private Date date;

    private UserDto userDto;

    private MovieDto movieDto;
}
