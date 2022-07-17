package com.example.moviebookingticket.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private Date birthdate;

    private String role;

    private String email;

    private String telephone;
}
