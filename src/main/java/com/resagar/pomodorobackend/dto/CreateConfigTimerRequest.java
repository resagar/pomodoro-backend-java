package com.resagar.pomodorobackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateConfigTimerRequest {
    private UUID id;
    private int workTimer;
    private int shortTimer;
    private int largeTimer;
}
