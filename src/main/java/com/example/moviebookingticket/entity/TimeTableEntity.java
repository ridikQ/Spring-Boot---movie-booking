package com.example.moviebookingticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="timeTable")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name="start_time")
    private Time startTime;

    @Column(name="end_time")
    private Time endTime;

    @ManyToOne
    @JoinColumn(name="movie_id")
    @JsonIgnore
    private MovieEntity movieEntity;
}
