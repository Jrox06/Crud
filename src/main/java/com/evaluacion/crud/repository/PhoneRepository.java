package com.evaluacion.crud.repository;

import com.evaluacion.crud.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
