package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.TheaterDto;
import com.example.moviebookingticket.entity.TheaterEntity;
import com.example.moviebookingticket.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping("/all")
    public List<TheaterDto>getAllTheaters(){
       return theaterService.getAllTheaters();
    }
    @PostMapping("/add")
    public void addTheater(@RequestBody TheaterDto theaterDto){
        theaterService.addTheater(theaterDto);
    }
}
