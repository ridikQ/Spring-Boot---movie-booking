package com.example.moviebookingticket.controller;

import com.example.moviebookingticket.dto.TimeTableDto;
import com.example.moviebookingticket.entity.TimeTableEntity;
import com.example.moviebookingticket.services.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/timetable")
public class TimeTableController {
    @Autowired
    private TimeTableService timeTableService;

    @PostMapping("/add")
    public ResponseEntity<TimeTableDto>addTimeTable(@RequestBody TimeTableDto timeTableDto) {
       return ResponseEntity.ok(timeTableService.addTimeTable(timeTableDto));
    }
}
