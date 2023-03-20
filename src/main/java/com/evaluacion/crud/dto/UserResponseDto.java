package com.evaluacion.crud.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDto {
    @Nullable
    private UUID id;
    @Nullable
    private LocalDateTime created;
    @Nullable
    private LocalDateTime modified;
    @Nullable
    private LocalDateTime last_login;
    @Nullable
    private String token;
    @Nullable
    private Boolean isActive;
}
