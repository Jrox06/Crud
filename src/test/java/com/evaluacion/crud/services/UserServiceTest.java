package com.evaluacion.crud.services;

import com.evaluacion.crud.entity.User;
import com.evaluacion.crud.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    User userRequest = new User();

    @BeforeEach
    void setUp() {
        userRequest.setName("Joel");
        userRequest.setEmail("Joel@gmail.com");
        userRequest.setUpdate(LocalDateTime.now());
        userRequest.setLastLogin(LocalDateTime.now());
        userRequest.setCreateAt(LocalDateTime.now());
        userRequest.setIsActive(true);
        userRequest.setPassword("Hunter837");
    }

    @Test
    @DisplayName("Successful user saving")
    void saveTest() {
        User user = userRepository.save(userRequest);

        assertThat(user.getId()).isNotEqualTo(null);
    }

    @Test
    @DisplayName("Successful user email search")
    void findEmailTest() {
        User user = userRepository.save(userRequest);

        User userResponse = userRepository.findById(user.getId()).get();
        Assertions.assertNotNull(userResponse);
    }

    @Test
    @DisplayName("Successful user search")
    void findUserId() {
        User user = userRepository.save(userRequest);

        Optional<User> userResponse = userRepository.findById(user.getId());
        Assertions.assertNotNull(userResponse);
    }
}
