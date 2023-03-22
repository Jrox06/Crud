package com.evaluacion.crud.services;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {
    public UserResponseDto createUser(UserDto userDto);
    public User findUserById(UUID id);

    public User findUser(String email);

    public void updateUser(UUID uuid, UserDto userDto);
}
