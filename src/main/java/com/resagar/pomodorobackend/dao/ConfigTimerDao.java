package com.resagar.pomodorobackend.dao;

import com.resagar.pomodorobackend.entities.ConfigTimer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConfigTimerDao extends JpaRepository<ConfigTimer, UUID> {
    Optional<ConfigTimer> findByUserId(UUID userId);
}
