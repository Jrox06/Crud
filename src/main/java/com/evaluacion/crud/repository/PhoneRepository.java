package com.evaluacion.crud.repository;

import com.evaluacion.crud.entity.Phone;
import com.evaluacion.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
