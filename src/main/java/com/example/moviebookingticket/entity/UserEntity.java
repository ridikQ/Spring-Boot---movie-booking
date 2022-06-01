package com.example.moviebookingticket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="birthdate")
    private Date birthdate;

    @Column(name="role")
    private String role;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(mappedBy = "user")
    private List<BookingEntity>bookingEntities=new ArrayList<>();
}
