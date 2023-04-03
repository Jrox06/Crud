package com.evaluacion.crud.services;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {
    UserResponseDto createUser(UserDto userDto);
    User findUserById(UUID id);

    User findUserByEmail(String email);

    User updateUser(UUID uuid, UserDto userDto);
}
