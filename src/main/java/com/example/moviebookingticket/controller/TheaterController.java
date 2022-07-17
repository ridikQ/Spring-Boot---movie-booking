package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.TheaterDto;
import com.example.moviebookingticket.entity.TheaterEntity;
import com.example.moviebookingticket.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping("/all")
    public ResponseEntity<List<TheaterDto>>  getAllTheaters() {
        return new ResponseEntity<>(theaterService.getAllTheaters(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TheaterDto> addTheater(@RequestBody TheaterDto theaterDto) {
        return ResponseEntity.ok(theaterService.addTheater(theaterDto)) ;
    }
}
