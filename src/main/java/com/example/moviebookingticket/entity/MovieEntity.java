package com.example.moviebookingticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "technology")
    private String technology;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonIgnore
    private TheaterEntity theaterId;

    @OneToMany(mappedBy = "movie")
    private List<BookingEntity> bookingEntities = new ArrayList<>();

    @OneToMany(mappedBy = "movieEntity")
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();

}
