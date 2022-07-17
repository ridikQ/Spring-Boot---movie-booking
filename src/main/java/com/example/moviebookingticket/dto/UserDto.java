package com.example.moviebookingticket.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.Null;
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

    private String password;

    private String telephone;

}
