package com.evaluacion.crud.services;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.User;
import com.evaluacion.crud.execeptions.ExceptionRuntimeHandler;
import com.evaluacion.crud.mapper.UserMapper;
import com.evaluacion.crud.repository.UserRepository;
import com.evaluacion.crud.utils.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Validations validations;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, Validations validations) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.validations = validations;
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        Optional<User> findUser = this.userRepository.findByEmail(userDto.getEmail());
        if (findUser.isPresent()) {
            throw new ExceptionRuntimeHandler("El correo ya se encuentra registrado", HttpStatus.BAD_REQUEST);
        }

        Boolean validationPassword = validations.validationPassword(userDto.getPassword());
        if (!validationPassword) {
            throw new ExceptionRuntimeHandler("Password no cumple con las condiciones", HttpStatus.BAD_REQUEST);
        }

        Boolean validationEmail = validations.validationEmail(userDto.getEmail());
        if (!validationEmail) {
            throw new ExceptionRuntimeHandler("El email no tiene un formato correcto", HttpStatus.BAD_REQUEST);
        }

        User userEntity = userMapper.map(userDto);
        this.userRepository.save(userEntity);
        return this.userMapper.mapResponseCreate(userEntity);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new ExceptionRuntimeHandler("No se encontro registro para el email", HttpStatus.BAD_REQUEST));
    }
    @Override
    public User findUserById(UUID id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ExceptionRuntimeHandler("No se encontro resultado para la busqueda", HttpStatus.BAD_REQUEST));
    }

    @Override
    public User updateUser(UUID uuid, UserDto userDto) {
        User user = this.findUserById(uuid);

        user.setUpdate(LocalDateTime.now());
        if (userDto.getIsActive() != null) user.setIsActive(userDto.getIsActive());
        if (userDto.getName() != null) user.setName(userDto.getName());
        if (userDto.getEmail() != null) user.setEmail(userDto.getEmail());
        if (userDto.getPassword() != null) user.setPassword(userDto.getPassword());

        return userRepository.save(user);
    }
}
