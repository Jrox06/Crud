package com.evaluacion.crud.mapper;

import com.evaluacion.crud.dto.PhoneDto;
import com.evaluacion.crud.dto.UserDto;
import com.evaluacion.crud.entity.Phone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PhoneMapper implements IMapper<UserDto, List<Phone>>{

    @Override
    public List<Phone> map(UserDto userDto) {
        List<Phone> phones = new ArrayList<>();
        for (PhoneDto phoneDto : userDto.getPhones()) {
            Phone phone = new Phone();
            phone.setNumber(phoneDto.getNumber());
            phone.setCityCode(phoneDto.getCitycode());
            phone.setContryCode(phoneDto.getContrycode());
            phones.add(phone);
        }
        return phones;
    }
}