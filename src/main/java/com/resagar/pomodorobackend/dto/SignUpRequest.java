package com.resagar.pomodorobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}