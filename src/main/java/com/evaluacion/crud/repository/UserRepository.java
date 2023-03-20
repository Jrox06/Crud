package com.evaluacion.crud.repository;

import com.evaluacion.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(@Param("email") String email);

}
