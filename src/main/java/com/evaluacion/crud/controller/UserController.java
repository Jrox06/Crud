package com.evaluacion.crud.controller;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findUser(@PathVariable("id") UUID id) {
        return new ResponseEntity(this.userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("find/email/{email}")
    public ResponseEntity findUserToEmail(@PathVariable("email") String email) {
        return new ResponseEntity(this.userService.findUser(email), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") UUID id, @RequestBody UserDto userDto) {
        this.userService.updateUser(id, userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}