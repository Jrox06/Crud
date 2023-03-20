package com.evaluacion.crud.services;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.User;
import com.evaluacion.crud.execeptions.ExceptionRuntimeHandler;
import com.evaluacion.crud.mapper.UserMapper;
import com.evaluacion.crud.repository.UserRepository;
import com.evaluacion.crud.utils.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Validations validations;

    public UserService(UserRepository userRepository, UserMapper userMapper, Validations validations) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.validations = validations;
    }

    public UserResponseDto createUser(UserDto userDto) {
        User findUser = this.findUser(userDto.getEmail());
        if (findUser != null) {
            throw new ExceptionRuntimeHandler("El correo ya se encuentra registrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Boolean validationPassword = validations.validationPassword(userDto.getPassword());
        if (!validationPassword) {
            throw new ExceptionRuntimeHandler("Password no cumple con las condiciones", HttpStatus.BAD_REQUEST);
        }

        User userEntity = userMapper.map(userDto);

        this.userRepository.save(userEntity);

        return userMapper.mapResponseCreate(userEntity);
    }

    public User findUser(String email) {
        User user = this.userRepository.findByEmail(email);
        return user;
    }

    public User findUserById(UUID id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("No se encontro registro");
        }
        return userOptional.orElseThrow();
    }

    public void updateUser(UUID uuid, UserDto userDto){
      Optional<User> optionalUser = userRepository.findById(uuid);
      if(optionalUser.isPresent()) {
          User user = optionalUser.get();
          user.setUpdate(LocalDateTime.now());
          if(userDto.getIsActive() != null) user.setIsActive(userDto.getIsActive());
          if(userDto.getName() != null)  user.setName(userDto.getName());
          if(userDto.getEmail() != null) user.setEmail(userDto.getEmail());
          if(userDto.getPassword() !=null) user.setPassword(userDto.getPassword());

          userRepository.save(user);
      }
    }
}
