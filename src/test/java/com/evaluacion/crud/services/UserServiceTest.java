package com.evaluacion.crud.services;

import com.evaluacion.crud.dto.PhoneDto;
import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.User;
import com.evaluacion.crud.execeptions.ExceptionRuntimeHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    User userRequest = new User();
    UserDto userDto = new UserDto();
    List<PhoneDto> phones = new ArrayList<>();
    PhoneDto phone = new PhoneDto();


    @BeforeEach
    void setUp() {
        userRequest.setName("Joel");
        userRequest.setEmail("Joel@gmail.com");
        userRequest.setUpdate(LocalDateTime.now());
        userRequest.setLastLogin(LocalDateTime.now());
        userRequest.setCreateAt(LocalDateTime.now());
        userRequest.setIsActive(true);
        userRequest.setPassword("Hunter837");

        phone.setCitycode("1");
        phone.setNumber("1234123123");
        phone.setContrycode("58");
        phones.add(phone);
        userDto.setName("Joel");
        userDto.setPassword("Hunter837");
        userDto.setPhones(phones);

    }

    @Test
    @DisplayName("Successful user saving")
    void saveUserHappyTest() {
        userDto.setEmail("joel@gmail.com");
        UserResponseDto user = userService.createUser(userDto);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("Email Error: user saving")
    void errorSaveTest() {
        try {
            userDto.setEmail("juan@rodrigues.org");
            userService.createUser(userDto);
            userService.createUser(userDto);
        } catch (ExceptionRuntimeHandler e) {
            Assertions.assertEquals("El correo ya se encuentra registrado", e.getMessage());
        }
    }

    @Test
    @DisplayName("Error Email: invalid format")
    void errorEmailTest() {
        try {
            userDto.setEmail("joel@a-com");
            userService.createUser(userDto);
        } catch (ExceptionRuntimeHandler e) {
            Assertions.assertEquals("El email no tiene un formato correcto", e.getMessage());
        }
    }
    @Test
    @DisplayName("Error Password: user saving")
    void errorPasswordTest() {
        try {
            userDto.setPassword("123");
            userService.createUser(userDto);
        } catch (ExceptionRuntimeHandler e) {
            Assertions.assertEquals("Password no cumple con las condiciones", e.getMessage());
        }
    }
}
