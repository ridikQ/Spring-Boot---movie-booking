package com.example.moviebookingticket.converters;

import com.example.moviebookingticket.dto.BookingDto;
import com.example.moviebookingticket.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingConverter implements BidirectionalConverter<BookingDto, BookingEntity> {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private MovieConverter movieConverter;

    @Override
    public BookingDto toDto(BookingEntity bookingEntity) {
        BookingDto bookingDto=new BookingDto();
        bookingDto.setId(bookingEntity.getId());
        bookingDto.setSeatAmount(bookingEntity.getSeatAmount());
        bookingDto.setDate(bookingEntity.getDate());
        bookingDto.setUserDto(userConverter.toDto(bookingEntity.getUser()));
        bookingDto.setMovieDto(movieConverter.toDto(bookingEntity.getMovie()));
        return bookingDto;
    }

    @Override
    public BookingEntity toEntity(BookingDto bookingDto) {
        BookingEntity bookingEntity=new BookingEntity();
        bookingEntity.setId(bookingDto.getId());
        bookingEntity.setSeatAmount(bookingDto.getSeatAmount());
        bookingEntity.setDate(bookingDto.getDate());
        bookingEntity.setUser(userConverter.toEntity(bookingDto.getUserDto()));
        bookingEntity.setMovie(movieConverter.toEntity(bookingDto.getMovieDto()));
        return bookingEntity;
    }
}
