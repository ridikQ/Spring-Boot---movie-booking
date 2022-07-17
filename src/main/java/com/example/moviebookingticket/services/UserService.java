package com.example.moviebookingticket.services;

import com.example.moviebookingticket.converters.UserConverter;
import com.example.moviebookingticket.dto.UserDto;
import com.example.moviebookingticket.entity.UserEntity;
import com.example.moviebookingticket.exception.CustomUserException;
import com.example.moviebookingticket.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
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
                    System.out.println("Password is mandatory");
                    throw new CustomUserException("Password is mandatory");
                }
            }else{
                System.out.println("Email is mandatory");
                throw new CustomUserException("Email is mandatory");
            }
        }
        return null;
    }

    public Optional<UserEntity> getUserById(Long id) {
        UserDto userDto = userConverter.toDto(new UserEntity());
        return userRepository.findById(id);
    }


}
