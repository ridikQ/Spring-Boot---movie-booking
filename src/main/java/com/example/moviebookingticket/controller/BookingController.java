package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.BookingDto;
import com.example.moviebookingticket.entity.BookingEntity;
import com.example.moviebookingticket.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> getBooking() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PostMapping("/add")
    public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto) {
       return ResponseEntity.ok(bookingService.addBooking(bookingDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id")Long id){
      return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDto> deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity("Booking deleted", HttpStatus.NO_CONTENT);
    }
}
