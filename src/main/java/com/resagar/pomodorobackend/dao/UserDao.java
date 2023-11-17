package com.resagar.pomodorobackend.dao;

import com.resagar.pomodorobackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
