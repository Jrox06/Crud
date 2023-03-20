package com.evaluacion.crud.mapper;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.entity.Phone;
import com.evaluacion.crud.entity.User;

import java.util.List;

public interface IMappers<Input, OutPut> {

   List<Phone> map(UserDto userDto, User user);
}
