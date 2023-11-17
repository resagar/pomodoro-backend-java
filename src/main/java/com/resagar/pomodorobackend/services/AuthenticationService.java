package com.resagar.pomodorobackend.services;

import com.resagar.pomodorobackend.dao.UserDao;
import com.resagar.pomodorobackend.dto.JwtAuthenticationResponse;
import com.resagar.pomodorobackend.dto.SignInRequest;
import com.resagar.pomodorobackend.dto.SignUpRequest;
import com.resagar.pomodorobackend.entities.Role;
import com.resagar.pomodorobackend.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationService{
    private final UserDao userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().id(request.getId()).firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}