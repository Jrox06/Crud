package com.evaluacion.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "user_client")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    private UUID id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime update;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
    @JoinColumn(name = "userId")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

}
