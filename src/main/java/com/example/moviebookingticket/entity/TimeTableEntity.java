package com.example.moviebookingticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "time_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

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
