package com.example.moviebookingticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "timetable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @FutureOrPresent
    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private MovieEntity movieEntity;
}
