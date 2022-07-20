package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.UserConverter;
import com.example.moviebookingticket.dto.UserDto;
import com.example.moviebookingticket.entity.UserEntity;
import com.example.moviebookingticket.exception.CustomUserException;
import com.example.moviebookingticket.exception.UserNotFoundException;
import com.example.moviebookingticket.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::toDto).collect(Collectors.toList());
    }

    public UserDto addUser(UserDto userDto) {
        if(userDto !=null){
            if (!userDto.getEmail().isEmpty()){
                if(!userDto.getPassword().isEmpty()){
                    UserEntity userEntity = userConverter.toEntity(userDto);
                    userRepository.save(userEntity);
                    return userDto;
                }else{
                   log.error("Password nedded");
                    throw new CustomUserException("Password is mandatory");
                }
            }else{
                log.error("Email nedded");
                throw new CustomUserException("Email is mandatory");
            }
        }
        return null;
    }
    public UserDto getUserById(Long id){

        return userConverter.toDto(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }


}
