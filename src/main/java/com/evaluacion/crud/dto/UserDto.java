package com.evaluacion.crud.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;

    private String email;

    private String password;
    private Boolean isActive;
    private List<PhoneDto> phones;

}
