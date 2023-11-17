package com.resagar.pomodorobackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "config_timer")
public class ConfigTimer {
    @Id
    private UUID id;

    @Column(name = "work_timer", nullable = false)
    private int workTimer;

    @Column(name = "short_timer", nullable = false)
    private int shortTimer;

    @Column(name = "large_timer", nullable = false)
    private int largeTimer;

    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;
}
