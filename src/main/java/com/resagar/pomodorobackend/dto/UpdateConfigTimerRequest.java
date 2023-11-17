package com.resagar.pomodorobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateConfigTimerRequest {
    private int workTimer;
    private int shortTimer;
    private int largeTimer;
}
