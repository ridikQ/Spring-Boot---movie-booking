package com.example.moviebookingticket.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="theater")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(name="theater_name")
    private String theaterName;

    @Column(name="seat_total")
    private Integer seatTotal;

    @OneToMany(mappedBy = "theaterId")
    private List<MovieEntity> movie=new ArrayList<>();

}
