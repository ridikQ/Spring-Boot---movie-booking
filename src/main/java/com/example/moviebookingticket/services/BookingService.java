package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.BookingConverter;
import com.example.moviebookingticket.dto.BookingDto;
import com.example.moviebookingticket.entity.BookingEntity;
import com.example.moviebookingticket.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

@Autowired
    private BookingRepository bookingRepository;

@Autowired
    private BookingConverter bookingConverter;

public List<BookingDto>getAllBookings(){
   return bookingRepository.findAll().stream().map(bookingConverter::toDto).collect(Collectors.toList());
}
public void addBooking(BookingDto bookingDto){
    BookingEntity bookingEntity=bookingConverter.toEntity(bookingDto);
    bookingRepository.save(bookingEntity);
}
    public Optional<BookingEntity> getBookingById(Long id){
        BookingDto bookingDto=bookingConverter.toDto(new BookingEntity());
        return  bookingRepository.findById(id);
    }
    public void deleteBooking(Long id){
    bookingRepository.deleteById(id);
    }

   /* public List<BookingEntity> getAllBookings(){
        return bookingRepository.findAll();
    }
    public void addBooking(BookingEntity bookingEntity){
            bookingRepository.save(bookingEntity);
    }
    public Optional<BookingEntity> getBookingById(Long id){
        return bookingRepository.findById(id);
    }
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }*/
}
