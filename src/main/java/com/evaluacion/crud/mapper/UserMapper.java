package com.evaluacion.crud.mapper;

import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.dto.UserResponseDto;
import com.evaluacion.crud.entity.Phone;
import com.evaluacion.crud.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserMapper implements IMapper<UserDto, User> {
    private final PhoneMapper phoneMapper;

    public UserMapper(PhoneMapper phoneMapper) {
        this.phoneMapper = phoneMapper;
    }

    @Override
    public User map(UserDto userDto) {

        User user = new User();
        LocalDateTime dateTime = LocalDateTime.now();
        List<Phone> phones = this.phoneMapper.map(userDto);

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreateAt(dateTime);
        user.setLastLogin(dateTime);
        user.setUpdate(dateTime);
        user.setIsActive(true);
        user.setPhones(phones);
        return user;
    }

    public UserResponseDto mapResponseCreate (User user) {
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setCreated(user.getCreateAt());
        userResponse.setModified(user.getUpdate());
        userResponse.setLast_login(user.getLastLogin());
        userResponse.setToken(user.getToken());
        userResponse.setIsActive(user.getIsActive());
        return userResponse;
    }
}
