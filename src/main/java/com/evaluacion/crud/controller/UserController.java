package com.evaluacion.crud.controller;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.entity.User;
import com.evaluacion.crud.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findUser(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("find/email")
    public ResponseEntity findUserToEmail(@RequestParam("email") String email) {
        return new ResponseEntity<>(this.userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(this.userService.updateUser(id, userDto), HttpStatus.CREATED);

    }
}